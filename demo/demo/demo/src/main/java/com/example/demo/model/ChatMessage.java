package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage implements Serializable {
    private static final long serialVersionUID = 1L; // Thêm serialVersionUID để đảm bảo tính tương thích

    private String sender;
    private String content;
    private String timestamp;
}
