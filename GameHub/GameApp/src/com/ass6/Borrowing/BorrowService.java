package com.ass6.Borrowing;

import com.ass6.Game.Game;
import com.ass6.User.User;

import java.util.*;

public interface BorrowService {
    public Game findGameById(int id);

    public String issueGame(int gameId, User user);

    public String returnGame(int gameId, User user);

    public void showBorrowedGamesQueue();

}
