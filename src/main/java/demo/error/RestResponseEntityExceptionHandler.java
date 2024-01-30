package demo.error;

import demo.Entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
/*whatever class that you are creating handle all your Exception
that particular class should annotate with this,if we had Exception controller spring would search for
this annotation class too
whenever there is exception in my controller this particular controller will handle  those kinds of
exception, and it will send back as resonance object

so this class will execute when we have exception in controller like get post and put and ...
*/
@ResponseStatus
/*
i think if we want to change response body by class we should annotate the class that wants to do that
and we declare the class that has duty to change the message of the exception is this
*/
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DepartmentNotFoundException.class)//this annotation help the spring to execute this method
    // when we throw the class that we have in ()
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){

        //this method controller some kind of exception in another class
        //actually it will order the exception error and instead of printing lots of code ,printing just message and two line
        //
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }



}
