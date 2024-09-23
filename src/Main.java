import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int user1Balance = 1000;
        int user2Balance = 800;
        int user3Balance = 1200;
        int successfulWithdrawals = 0;

        for (int user = 1; user <= 3; user++) {
            int userBalance = 0;
            if (user == 1) {
                userBalance = user1Balance;
            } else if (user == 2) {
                userBalance = user2Balance;
            } else if (user == 3) {
                userBalance = user3Balance;
            }

            while (true) {
                System.out.println("User " + user + " has a balance of " + userBalance);
                System.out.print("Enter amount to withdraw (or -1 to exit): ");
                int withdrawal = scanner.nextInt();

                if (withdrawal == -1) {
                    System.out.println("User " + user + " chose to exit.");
                    break;
                } else if (withdrawal <= 0) {
                    System.out.println("Invalid amount. Please try again.");
                    continue;
                } else if (withdrawal > userBalance) {
                    System.out.println("Insufficient balance. Please try again.");
                    continue;
                } else if (withdrawal > 500) {
                    System.out.println("Transaction limit exceeded! Cannot withdraw more than $500 at once.");
                    break;
                }
                else {

                    userBalance -= withdrawal;
                    System.out.println("User " + user + " successfully withdrew $" + withdrawal);
                    successfulWithdrawals++;

                    switch (user) {
                        case 1:
                            user1Balance = userBalance;
                            break;
                        case 2:
                            user2Balance = userBalance;
                            break;
                        case 3:
                            user3Balance = userBalance;
                            break;
                    }

                    if (successfulWithdrawals == 3) {
                        System.out.println("3 successful withdrawals made. Ending program.");
                        break;
                    }
                }

                if (successfulWithdrawals == 3) {
                    break;
                }
            }
        }

        // Final Balances
        System.out.println("Final Balances:");
        System.out.println("User 1: " + user1Balance);
        System.out.println("User 2: " + user2Balance);
        System.out.println("User 3: " + user3Balance);
    }
}
