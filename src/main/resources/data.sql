-- Inserting data into the `roles` table
INSERT INTO `roles` (`id`, `description`, `name`) VALUES
('1a2b3c4d-1234-abcd-5678-abcdef123456', 'System Administrator', 'Admin'),
('2b3c4d5e-2345-bcde-6789-bcdefg234567', 'Store Salesperson', 'Salesperson'),
('3c4d5e6f-3456-cdef-789a-cdefgh345678', 'Branch Manager', 'Manager');

-- Inserting data into the `users` table
INSERT INTO `users` (`id`, `email`, `firstname`, `lastname`, `password`, `phone`, `rol_id`) VALUES
('4d5e6f7g-4567-efgh-89ab-defghi456789', 'admin@example.com', 'Admin', 'User', 'adminpass', '1234567890', '1a2b3c4d-1234-abcd-5678-abcdef123456'),
('5e6f7g8h-5678-fghi-9abc-efghij567890', 'salesperson@example.com', 'Salesperson', 'User', 'salespersonpass', '9876543210', '2b3c4d5e-2345-bcde-6789-bcdefg234567'),
('6f7g8h9i-6789-ghij-abcd-fghijk678901', 'manager@example.com', 'Manager', 'User', 'managerpass', NULL, '3c4d5e6f-3456-cdef-789a-cdefgh345678');

-- Inserting data into the `stores` table
INSERT INTO `stores` (`id`, `name`, `user_id`) VALUES
(1, 'Main Store', '4d5e6f7g-4567-efgh-89ab-defghi456789'),
(2, 'North Branch', '5e6f7g8h-5678-fghi-9abc-efghij567890'),
(3, 'South Branch', '6f7g8h9i-6789-ghij-abcd-fghijk678901');

-- Inserting data into the `branches` table
INSERT INTO `branches` (`id`, `city`, `country`, `email`, `phone`, `postal_code`, `province`, `store_id`) VALUES
('7g8h9i0j-7890-hijk-bcde-ghijkl789012', 'Bogotá', 'Colombia', 'bogota@mainstore.com', '123456789', '110111', 'Cundinamarca', 1),
('8h9i0j1k-8901-ijkl-cdef-hijklm890123', 'Medellín', 'Colombia', 'medellin@northbranch.com', '987654321', '050051', 'Antioquia', 2),
('9i0j1k2l-9012-jklm-defg-ijklmn901234', 'Cali', 'Colombia', 'cali@southbranch.com', NULL, '760761', 'Valle del Cauca', 3);

-- Inserting data into the `cash_machines` table
INSERT INTO `cash_machines` (`id`, `branch_id`) VALUES
('0j1k2l3m-0123-klmn-efgh-jklmno012345', '7g8h9i0j-7890-hijk-bcde-ghijkl789012'),
('1k2l3m4n-1234-lmno-fghi-mnopqr123456', '8h9i0j1k-8901-ijkl-cdef-hijklm890123'),
('2l3m4n5o-2345-mnop-ghij-nopqrs234567', '9i0j1k2l-9012-jklm-defg-ijklmn901234');

-- Inserting data into the `cash_registers` table
INSERT INTO `cash_registers` (`id`, `cash_id`) VALUES
('3m4n5o6p-3456-nopq-hijk-opqrst345678', '0j1k2l3m-0123-klmn-efgh-jklmno012345'),
('4n5o6p7q-4567-opqr-ijkl-pqrstu456789', '1k2l3m4n-1234-lmno-fghi-mnopqr123456'),
('5o6p7q8r-5678-pqrs-jklm-qrstuv567890', '2l3m4n5o-2345-mnop-ghij-nopqrs234567');

-- Inserting data into the `categories` table
INSERT INTO `categories` (`id`, `description`, `name`) VALUES
('6q7r8s9t-6789-qrst-uvwx-rstuvw678901', 'Electronics', 'Electronics'),
('7r8s9t0u-7890-rstu-vwxy-stuvwx789012', 'Clothing', 'Clothing'),
('8s9t0u1v-8901-stuv-wxyz-tuvwxy890123', 'Home', 'Home');

-- Inserting data into the `discount` table
INSERT INTO `discount` (`id`, `amount`, `code`, `discount_date`, `is_active`, `type`) VALUES
('9t0u1v2w-9012-tuvw-xyz0-uvwxyz901234', 10.00, 'DESC10', '2024-06-26 00:00:00', 1, 'PERCENTAGE'),
('0u1v2w3x-0123-uvwx-yza1-vwxyza012345', 25.00, 'SALE25', '2024-06-26 00:00:00', 1, 'FIXED');

-- Inserting data into the `memberships` table
INSERT INTO `memberships` (`id`, `description`, `price`, `type`) VALUES
('1v2w3x4y-1234-vwxy-za12-wxyzab123456', 'Platinum Membership', 150.00, 'ANNUAL'),
('2w3x4y5z-2345-wxyz-ab12-xyzabc234567', 'Gold Membership', 75.00, 'ANNUAL');

-- Inserting data into the `supplier` table
INSERT INTO `supplier` (`id`, `address`, `contact`, `email`, `name`, `phone`) VALUES
('3x4y5z6a-3456-xyz0-bcde-yzabcd345678', '45th Street, Bogotá', 'John Doe', 'john@electronichardware.com', 'Electronic Suppliers Inc.', 1122334455),
('4y5z6a7b-4567-yzab-cdef-zabcd678901', 'Main Avenue, Medellín', 'Jane Smith', 'jane@clothingsuppliers.com', 'Clothing Suppliers Ltd.', 9988776655);

-- Inserting data into the `supplier_order` table
INSERT INTO `supplier_order` (`id`, `note`, `sub_total`, `tax`, `total`, `inventory_id`, `supplier_id`) VALUES
('5z6a7b8c-5678-zabc-defg-abcde789012', 'Initial electronics order', 500.00, 50.00, 550.00, NULL, '3x4y5z6a-3456-xyz0-bcde-yzabcd345678'),
('6a7b8c9d-6789-abcd-efgh-bcdef890123', 'Clothing restock', 300.00, 30.00, 330.00, NULL, '4y5z6a7b-4567-yzab-cdef-zabcd678901');

-- Inserting data into the `inventories` table
INSERT INTO `inventories` (`id`, `expiration_date`, `last_update_date`, `product_id`, `quantity`, `store_id`, `supplier_order_id`, `branch_id`) VALUES
('7b8c9d0e-7890-bcde-fghi-cdefg901234', '2025-06-26 00:00:00', '2024-06-26 00:00:00', '9d0e1f2g-8901-cdef-ghij-defgh012345', 100, 1, '5z6a7b8c-5678-zabc-defg-abcde789012', NULL),
('8c9d0e1f-8901-cdef-ghij-defg-hijkl123456', '2025-06-26 00:00:00', '2024-06-26 00:00:00', '0e1f2g3h-9012-defg-hijk-efghi234567', 200, 2, '6a7b8c9d-6789-abcd-efgh-bcdef890123', NULL);

-- Inserting data into the `product` table
INSERT INTO `product` (`id`, `barcode`, `buying_price`, `description`, `name`, `selling_price`, `category_id`, `inventory_id`) VALUES
('9d0e1f2g-8901-cdef-ghij-defgh012345', '123456789012', 250.00, 'Advanced smartphone', 'Smartphone', 400.00, '6q7r8s9t-6789-qrst-uvwx-rstuvw678901', '7b8c9d0e-7890-bcde-fghi-cdefg901234'),
('0e1f2g3h-9012-defg-hijk-efghi234567', '987654321098', 50.00, 'Casual cotton t-shirt', 'T-Shirt', 80.00, '7r8s9t0u-7890-rstu-vwxy-stuvwx789012', '8c9d0e1f-8901-cdef-ghij-defg-hijkl123456');

-- Inserting data into the `sale` table
INSERT INTO `sale` (`id`, `customer`, `date`, `sub_total`, `tax`, `total`, `branch_id`, `cash_id`, `discount_id`, `user_id`) VALUES
('1f2g3h4i-0123-efgh-ijkl-fghij234567', 'Anonymous Customer', '2024-06-26 12:00:00', 480.00, 48.00, 528.00, '7g8h9i0j-7890-hijk-bcde-ghijkl789012', '0j1k2l3m-0123-klmn-efgh-jklmno012345', '9t0u1v2w-9012-tuvw-xyz0-uvwxyz901234', '4d5e6f7g-4567-efgh-89ab-defghi456789'),
('2g3h4i5j-1234-ghij-klmn-ghijkl345678', 'Registered Customer', '2024-06-26 14:30:00', 320.00, 32.00, 352.00, '8h9i0j1k-8901-ijkl-cdef-hijklm890123', '1k2l3m4n-1234-lmno-fghi-mnopqr123456', '0u1v2w3x-0123-uvwx-yza1-vwxyza012345', '5e6f7g8h-5678-fghi-9abc-efghij567890');

-- Inserting data into the `sale_detail` table
INSERT INTO `sale_detail` (`id`, `quantity`, `total`, `unit_price`, `inventory_id`, `sale_id`) VALUES
('3h4i5j6k-2345-hijk-lmno-ijklm456789', 2, 800.00, 400.00, '7b8c9d0e-7890-bcde-fghi-cdefg901234', '1f2g3h4i-0123-efgh-ijkl-fghij234567'),
('4i5j6k7l-3456-ijkl-mnop-jklmn567890', 4, 320.00, 80.00, '8c9d0e1f-8901-cdef-ghij-defg-hijkl123456', '2g3h4i5j-1234-ghij-klmn-ghijkl345678');

-- Inserting data into the `subscriptions` table
INSERT INTO `subscriptions` (`id`, `end_date`, `purchase_date`, `status`, `membership_id`, `user_id`) VALUES
(1, '2025-06-26', '2024-06-26', 'ACTIVE', '1v2w3x4y-1234-vwxy-za12-wxyzab123456', '6f7g8h9i-6789-ghij-abcd-fghijk678901'),
(2, '2025-06-26', '2024-06-26', 'ACTIVE', '2w3x4y5z-2345-wxyz-ab12-xyzabc234567', '5e6f7g8h-5678-fghi-9abc-efghij567890');
