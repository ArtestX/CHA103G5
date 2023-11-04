package com.cha103g5.customerservicerecord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEmail {
    String category;
    String name;
    String usermail;
    String content;
}
