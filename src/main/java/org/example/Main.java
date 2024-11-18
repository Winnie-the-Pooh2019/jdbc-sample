package org.example;

import org.example.service.MusicService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MusicService service;
        try {
            DataSourceManager manager = DataSourceManager.getInstance();
            service = new MusicService(manager.getDataSource());
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        service.findAll().orElse(new ArrayList<>()).forEach(System.out::println);
    }
}