create database haichanbank;

use haichanbank;


CREATE TABLE `customer` (
                            `customer_id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) NOT NULL,
                            `email` varchar(100) NOT NULL,
                            `mobile_number` varchar(20) NOT NULL,
                            `pwd` varchar(500) NOT NULL,
                            `role` varchar(100) NOT NULL,
                            `create_dt` date DEFAULT NULL,
                            `customer_is_active` boolean DEFAULT NULL,
                            PRIMARY KEY (`customer_id`)
);

INSERT INTO `customer` (`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`,`customer_is_active`)
VALUES ('Happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE(),1);

INSERT INTO `customer` (`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`,`customer_is_active`)
VALUES ('dungphung','dungphung@gmail.com','0123456789', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE(),1);

INSERT INTO `customer` (`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`,`customer_is_active`)
VALUES ('hieutran','hieutran@gmail.com','0563546345', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE(),1);

INSERT INTO `customer` (`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`,`customer_is_active`)
VALUES ('haingo','haingo@gmail.com','046124646246', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE(),1);


CREATE TABLE `accounts` (
                            `customer_id` int NOT NULL,
                            `account_number` int NOT NULL,
                            `account_type` varchar(100) NOT NULL,
                            `branch_address` varchar(200) NOT NULL,
                            `create_dt` date DEFAULT NULL,
                            `account_is_active` boolean DEFAULT NULL,
                            PRIMARY KEY (`account_number`),
                            KEY `customer_id` (`customer_id`),
                            CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_dt`,`account_is_active`)
VALUES (1, 1865764534, 'Savings', '123 Main Street, New York', CURDATE(),1);

INSERT INTO `haichanbank`.`accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_dt`, `account_is_active`)
VALUES (2, '1865764535', 'Savings', 'Thai Binh', '2023-06-26', '1');

INSERT INTO `haichanbank`.`accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_dt`, `account_is_active`)
VALUES (3, '1865764536', 'Savings', 'Ha Noi', '2023-06-26', '1');

INSERT INTO `haichanbank`.`accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_dt`, `account_is_active`)
VALUES (4, '1865764537', 'Savings', 'Ha Noi', '2023-06-26', '1');

CREATE TABLE `payment_history` (
                                   `payment_id` varchar(200) NOT NULL,
                                   `account_number` int NOT NULL,
                                   `customer_id` int NOT NULL,
                                   `payment_dt` date NOT NULL,
                                   `payment_summary` varchar(200) NOT NULL,
                                   `payment_type` varchar(100) NOT NULL,
                                   `payment_amt` int NOT NULL,
                                   `closing_balance` int NOT NULL,
                                   `create_dt` date DEFAULT NULL,
                                   PRIMARY KEY (`payment_id`),
                                   KEY `customer_id` (`customer_id`),
                                   KEY `account_number` (`account_number`),
                                   CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`account_number`) REFERENCES `accounts` (`account_number`) ON DELETE CASCADE,
                                   CONSTRAINT `acct_user_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `payment_history` (`payment_id`, `account_number`, `customer_id`, `payment_dt`, `payment_summary`, `payment_type`,`payment_amt`,
                               `closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, CURDATE()-7, 'Coffee Shop', 'Withdrawal', 30,34500,CURDATE()-7);

INSERT INTO `payment_history` (`payment_id`, `account_number`, `customer_id`, `payment_dt`, `payment_summary`, `payment_type`,`payment_amt`,
                               `closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, CURDATE()-6, 'Uber', 'Withdrawal', 100,34400,CURDATE()-6);

INSERT INTO `payment_history` (`payment_id`, `account_number`, `customer_id`, `payment_dt`, `payment_summary`, `payment_type`,`payment_amt`,
                               `closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, CURDATE()-5, 'Self Deposit', 'Deposit', 500,34900,CURDATE()-5);

INSERT INTO `payment_history` (`payment_id`, `account_number`, `customer_id`, `payment_dt`, `payment_summary`, `payment_type`,`payment_amt`,
                               `closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, CURDATE()-4, 'Ebay', 'Withdrawal', 600,34300,CURDATE()-4);

INSERT INTO `payment_history` (`payment_id`, `account_number`, `customer_id`, `payment_dt`, `payment_summary`, `payment_type`,`payment_amt`,
                               `closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, CURDATE()-2, 'OnlineTransfer', 'Deposit', 700,35000,CURDATE()-2);

INSERT INTO `payment_history` (`payment_id`, `account_number`, `customer_id`, `payment_dt`, `payment_summary`, `payment_type`,`payment_amt`,
                               `closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, CURDATE()-1, 'Amazon.com', 'Withdrawal', 100,34900,CURDATE()-1);


CREATE TABLE `loans` (
                         `loan_number` int NOT NULL AUTO_INCREMENT,
                         `customer_id` int NOT NULL,
                         `start_dt` date NOT NULL,
                         `loan_type` varchar(100) NOT NULL,
                         `total_loan` int NOT NULL,
                         `amount_paid` int NOT NULL,
                         `outstanding_amount` int NOT NULL,
                         `create_dt` date DEFAULT NULL,
                         PRIMARY KEY (`loan_number`),
                         KEY `customer_id` (`customer_id`),
                         CONSTRAINT `loan_customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `loans` ( `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES ( 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');

INSERT INTO `loans` ( `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES ( 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');

INSERT INTO `loans` ( `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES ( 1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO `loans` ( `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES ( 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

CREATE TABLE `cards` (
                         `card_id` int NOT NULL AUTO_INCREMENT,
                         `card_number` varchar(100) NOT NULL,
                         `customer_id` int NOT NULL,
                         `card_type` varchar(100) NOT NULL,
                         `total_limit` int NOT NULL,
                         `amount_used` int NOT NULL,
                         `available_amount` int NOT NULL,
                         `create_dt` date DEFAULT NULL,
                         PRIMARY KEY (`card_id`),
                         KEY `customer_id` (`customer_id`),
                         CONSTRAINT `card_customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `create_dt`)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURDATE());

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `create_dt`)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURDATE());

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `create_dt`)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURDATE());

CREATE TABLE `notice_details` (
                                  `notice_id` int NOT NULL AUTO_INCREMENT,
                                  `notice_summary` varchar(200) NOT NULL,
                                  `notice_details` varchar(500) NOT NULL,
                                  `notic_beg_dt` date NOT NULL,
                                  `notic_end_dt` date DEFAULT NULL,
                                  `create_dt` date DEFAULT NULL,
                                  `update_dt` date DEFAULT NULL,
                                  PRIMARY KEY (`notice_id`)
);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES ('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

INSERT INTO `notice_details` ( `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`)
VALUES ('COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        CURDATE() - INTERVAL 30 DAY, CURDATE() + INTERVAL 30 DAY, CURDATE(), null);

CREATE TABLE `contact_messages` (
                                    `contact_id` varchar(50) NOT NULL,
                                    `contact_name` varchar(50) NOT NULL,
                                    `contact_email` varchar(100) NOT NULL,
                                    `subject` varchar(500) NOT NULL,
                                    `message` varchar(2000) NOT NULL,
                                    `create_dt` date DEFAULT NULL,
                                    PRIMARY KEY (`contact_id`)
);

CREATE TABLE `authorities` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `customer_id` int NOT NULL,
                               `name` varchar(50) NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `customer_id` (`customer_id`),
                               CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
);

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'VIEWACCOUNT');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'VIEWCARDS');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'VIEWLOANS');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'VIEWBALANCE');

DELETE FROM `authorities`;

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_USER');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_ADMIN');

CREATE TABLE `saving_account` (
                                  `saving_account_id` int NOT NULL AUTO_INCREMENT,
                                  `card_id` int NOT NULL,
                                  `init_amount` int NOT NULL,
                                  `duration` int NOT NULL,
                                  `interest` float NOT NULL,
                                  `create_dt` date DEFAULT NULL,
                                  `expired_dt` date DEFAULT NULL,
                                  `saving_account_is_active` boolean DEFAULT NULL,
                                  PRIMARY KEY (`saving_account_id`),
                                  KEY `card_id` (`card_id`),
                                  CONSTRAINT `saving_account_card_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `cards` (`card_id`) ON DELETE CASCADE
);

INSERT INTO `haichanbank`.`saving_account` (`saving_account_id`, `card_id`, `init_amount`, `duration`, `interest`, `create_dt`, `expired_dt`, `saving_account_is_active`) VALUES ('1', '1', '100', '24', '0.1', '2020-10-13', '2022-10-13', '1');


CREATE TABLE `transaction` (
                               `transaction_id` int NOT NULL AUTO_INCREMENT,
                               `send_transaction_id` int NOT NULL,
                               `receive_transaction_id` int NOT NULL,
                               `amount` int NOT NULL,
                               `date` date DEFAULT NULL,
                               `transaction_is_active` tinyint(1) DEFAULT NULL,
                               PRIMARY KEY (`transaction_id`),
                               KEY `send_transaction_id` (`send_transaction_id`),
                               KEY `receive_transaction_id` (`receive_transaction_id`),
                               CONSTRAINT `receive_transaction_id_card_ibfk_1` FOREIGN KEY (`receive_transaction_id`) REFERENCES `accounts` (`account_number`) ON DELETE CASCADE,
                               CONSTRAINT `send_transaction_id_ibfk_1` FOREIGN KEY (`send_transaction_id`) REFERENCES `accounts` (`account_number`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `haichanbank`.`transaction` (`transaction_id`, `send_transaction_id`, `receive_transaction_id`, `amount`, `date`, `transaction_is_active`) VALUES ('1', '1865764534', '1865764535', '100', '2023-06-26', '1');

INSERT INTO `haichanbank`.`authorities` (`id`, `customer_id`, `name`) VALUES ('7', '2', 'ROLE_USER');
UPDATE `haichanbank`.`authorities` SET `name` = 'ROLE_ADMIN' WHERE (`id` = '6');
INSERT INTO `haichanbank`.`authorities` (`id`, `customer_id`, `name`) VALUES ('8', '2', 'ROLE_ADMIN');
INSERT INTO `haichanbank`.`authorities` (`id`, `customer_id`, `name`) VALUES ('9', '3', 'ROLE_ADMIN');
INSERT INTO `haichanbank`.`authorities` (`id`, `customer_id`, `name`) VALUES ('10', '3', 'ROLE_USER');
INSERT INTO `haichanbank`.`authorities` (`id`, `customer_id`, `name`) VALUES ('11', '4', 'ROLE_USER');
INSERT INTO `haichanbank`.`authorities` (`id`, `customer_id`, `name`) VALUES ('12', '4', 'ROLE_ADMIN');
