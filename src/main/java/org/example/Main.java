package org.example;

import java.io.*;
import java.util.List;

/*1) Реализуйте механизм сохранения и чтения объекта POJO класса Client в файл.
Вот приблизительно наполнение класса Client.
    private Long id;
    private String status;
    private Long taxCode;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

2) ** Научите данный механизм сохранять также список таких объектов в файл, и читать эти объекты из файла в List. */
public class Main {
    public static void main(String[] args) throws IOException {
        Client client = new Client(123L, "normal", 456L, "Tom", "Jon", "tom@gmail.com",
                "London, Super street 73", "789456123");

        List<Client> clientList = List.of(new Client(123L, "normal", 456L, "Tom",
                        "Jon", "tom@gmail.com", "London, Super street 73", "789456123"),
                new Client(123L, "normal", 456L, "Tom", "Jon", "tom@gmail.com",
                        "London, Super street 73", "789456123"),
                new Client(123L, "normal", 456L, "Tom", "Jon", "tom@gmail.com",
                        "London, Super street 73", "789456123"));


        savingAnObject(client);
        readingAnObject("Client.csv");
        savingAnListObject(clientList);
        readingAnListObject("Clients.csv");
    }

    public static void savingAnObject(Client client) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Client.csv"))) {
             fileWriter.write(String.valueOf(client));
            fileWriter.newLine();
        }
    }

    public static void savingAnListObject(List<Client> clients) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Clients.csv"))) {
            for (Client client : clients) {
                fileWriter.write(String.valueOf(client));
                fileWriter.newLine();
            }
        }
    }

    private static void readingAnObject(String filename) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String info;
            while ((info = fileReader.readLine()) != null)
                System.out.println(info);
        }
    }

    public static void readingAnListObject(String filename) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String clientList;
            while ((clientList = fileReader.readLine()) != null)
                System.out.println(clientList);
        }
    }
}
