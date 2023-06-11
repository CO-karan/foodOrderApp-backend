package com.foodOrder.foodOrderApp.api.v1.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class APIOrder {
    //todo IDEALLY WE SHOULD GET THE USER ID FROM A TOKENIZED SYSTEM BUT FOR NOW LETS FORCE IT AS I DON'T HAVE GOOD NOLIGE OF SPRING-SECURITY ;[
    UUID userId;
    CartItem[] cartItems;
}
