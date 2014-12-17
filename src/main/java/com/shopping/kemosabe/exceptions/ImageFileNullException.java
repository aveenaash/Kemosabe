package com.shopping.kemosabe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Cannot Read Image")
public class ImageFileNullException extends RuntimeException {
 
    private static final long serialVersionUID = -3332292346834265371L;
 
    public ImageFileNullException(){
        super("Product Image is Null. Please select Image and try again uploading again");
    }
}