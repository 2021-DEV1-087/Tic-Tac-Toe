package com.game.TicTacToe.dto;

import lombok.Data;

@Data
public class RequestGamingDto {
    private String playerSymbol ;

    private Integer positionX;

    private Integer positionY;

}