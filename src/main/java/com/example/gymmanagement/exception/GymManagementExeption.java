package com.example.gymmanagement.exception;


import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class GymManagementExeption  extends  RuntimeException{


    private final ErrorCode errorCode;

    public GymManagementExeption(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


}
