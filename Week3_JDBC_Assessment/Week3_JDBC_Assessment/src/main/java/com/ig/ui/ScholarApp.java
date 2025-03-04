package com.ig.ui;

import com.ig.exception.ScholarNotFoundException;
import com.ig.model.Scholar;
import com.ig.service.ScholarService;
import com.ig.service.ScholarServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ScholarApp {
    public static void main(String[] args) {
        ScholarService scholarService = new ScholarServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Scholar");
            System.out.println("2. List Scholars");
            System.out.println("3. Update Scholar Email");
            System.out.println("4. Delete Scholar");
            System.out.println("5. Get One Scholar By Id");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
//                        System.out.print("Enter ID: ");
//                        int id = scanner.nextInt();
//                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Email: ");
                        String email = scanner.next();
                        System.out.print("Enter Mobile: ");
                        String mobile = scanner.next();
                        scholarService.addScholar(new Scholar(name, email, mobile));
                        break;
                    case 2:
                        scholarService.listAllScholars();
                        List<Scholar> listofScholars = scholarService.listAllScholars();
                        for(Scholar s : listofScholars) {
                        	System.out.println(s);
                        }
                        break;
                    case 3:
                        System.out.print("Enter Scholar ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new Email: ");
                        String newEmail = scanner.nextLine();
                        scholarService.updateScholarEmail(updateId, newEmail);
                        System.out.println("Scholar Updated");
                        break;
                    case 4:
                        System.out.print("Enter Scholar ID to delete: ");
                        int deleteId = scanner.nextInt();
                        scholarService.deleteScholarById(deleteId);
                        System.out.println("Scholar deleted");
                        break;
                    case 5:
                        System.out.print("Enter Scholar ID to View: ");
                        int viewById = scanner.nextInt();
                        System.out.println(scholarService.getOneScholar(viewById));
                        break;
                    case 6:
                        System.exit(0);
                }
            } catch (ScholarNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

