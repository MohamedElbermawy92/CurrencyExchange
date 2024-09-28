package com.currencyexchange.exceptionHandle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class ErrorDetails {
    private LocalDate timeStamp;
    private String message;
}
