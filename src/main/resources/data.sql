-- `roles` table
INSERT INTO `riwi_localstorage`.`roles` (`id`, `description`, `name`) VALUES
('1', 'Admin role', 'Admin'),
('2', 'Cashier role', 'Cashier');

-- `users` table
INSERT INTO `riwi_localstorage`.`users` (`id`, `email`, `firstname`, `lastname`, `password`, `phone`, `rol_id`) VALUES
('1', 'admin@store.com', 'John', 'Doe', 'password123', '1234567890', '1'),
('2', 'cashier@store.com', 'Jane', 'Smith', 'password456', '0987654321', '2');

-- `stores` table
INSERT INTO `riwi_localstorage`.`stores` (`id`, `name`, `user_id`) VALUES
(1, 'Main Store', '1');

-- `branches` table
INSERT INTO `riwi_localstorage`.`branches` (`id`, `city`, `country`, `email`, `phone`, `postal_code`, `province`, `store_id`) VALUES
('1', 'City', 'Country', 'contact@store.com', '123456789', '12345', 'Province', 1);

-- `cash_machines` table
INSERT INTO `riwi_localstorage`.`cash_machines` (`id`, `branch_id`) VALUES
('1', '1');

-- `cash_registers` table
INSERT INTO `riwi_localstorage`.`cash_registers` (`id`, `cash_id`) VALUES
('1', '1');

-- `categories` table
INSERT INTO `riwi_localstorage`.`categories` (`id`, `description`, `name`) VALUES
('1', 'Beverages', 'Beverages'),
('2', 'Snacks', 'Snacks'),
('3', 'Dairy', 'Dairy');

-- `discount` table
INSERT INTO `riwi_localstorage`.`discount` (`id`, `amount`, `code`, `discount_date`, `is_active`, `type`) VALUES
('1', 10, 'DISC10', NOW(), b'1', 'PERCENTAGE');

-- `inventories` table
INSERT INTO `riwi_localstorage`.`inventories` (`id`, `expiration_date`, `last_update_date`, `product_id`, `quantity`, `store_id`, `supplier_order_id`, `branch_id`) VALUES
('1', '2024-12-31', NOW(), '1', 100, '1', '1', '1'),
('2', '2024-12-31', NOW(), '2', 150, '1', '1', '1'),
('3', '2024-12-31', NOW(), '3', 200, '1', '1', '1'),
('4', '2024-12-31', NOW(), '4', 50, '1', '1', '1'),
('5', '2024-12-31', NOW(), '5', 75, '1', '1', '1'),
('6', '2024-12-31', NOW(), '6', 120, '1', '1', '1'),
('7', '2024-12-31', NOW(), '7', 60, '1', '1', '1'),
('8', '2024-12-31', NOW(), '8', 180, '1', '1', '1'),
('9', '2024-12-31', NOW(), '9', 110, '1', '1', '1'),
('10', '2024-12-31', NOW(), '10', 90, '1', '1', '1');

-- `memberships` table
INSERT INTO `riwi_localstorage`.`memberships` (`id`, `description`, `price`, `type`) VALUES
('1', 'Basic Membership', 50, 'BASIC');

-- `product` table
INSERT INTO `riwi_localstorage`.`product` (`id`, `barcode`, `buying_price`, `description`, `name`, `selling_price`, `category_id`, `inventory_id`) VALUES
('1', '1234567890123', 5, 'Coca Cola 500ml', 'Coca Cola', 10, '1', '1'),
('2', '1234567890124', 3, 'Pepsi 500ml', 'Pepsi', 8, '1', '2'),
('3', '1234567890125', 2, 'Sprite 500ml', 'Sprite', 7, '1', '3'),
('4', '1234567890126', 4, 'Lays Chips 150g', 'Lays Chips', 9, '2', '4'),
('5', '1234567890127', 6, 'Doritos 150g', 'Doritos', 12, '2', '5'),
('6', '1234567890128', 3.5, 'KitKat 45g', 'KitKat', 6.5, '2', '6'),
('7', '1234567890129', 1.5, 'Oreo Cookies 120g', 'Oreo', 4.5, '2', '7'),
('8', '1234567890130', 4, 'Milk 1L', 'Milk', 7, '3', '8'),
('9', '1234567890131', 2, 'Cheese 200g', 'Cheese', 5, '3', '9'),
('10', '1234567890132', 3, 'Yogurt 500ml', 'Yogurt', 6, '3', '10');

-- `sale` table
INSERT INTO `riwi_localstorage`.`sale` (`id`, `customer`, `date`, `sub_total`, `tax`, `total`, `branch_id`, `cash_id`, `discount_id`, `user_id`) VALUES
('1', 'Customer1', NOW(), 100, 12, 112, '1', '1', '1', '2');

-- `sale_detail` table
INSERT INTO `riwi_localstorage`.`sale_detail` (`id`, `quantity`, `total`, `unit_price`, `inventory_id`, `sale_id`) VALUES
('1', 2, 20, 10, '1', '1');

-- `subscriptions` table
INSERT INTO `riwi_localstorage`.`subscritions` (`id`, `end_date`, `purchase_date`, `status`, `membership_id`, `user_id`) VALUES
('1', '2023-12-31', '2023-01-01', 'ACTIVE', '1', '2');

-- `supplier` table
INSERT INTO `riwi_localstorage`.`supplier` (`id`, `address`, `contact`, `email`, `name`, `phone`) VALUES
('1', '123 Fake Street', 'Supplier Contact', 'supplier@provider.com', 'Supplier1', '123456789');

-- `supplier_order` table
INSERT INTO `riwi_localstorage`.`supplier_order` (`id`, `note`, `sub_total`, `tax`, `total`, `inventory_id`, `supplier_id`) VALUES
('1', 'Order note', 200, 24, 224, '1', '1');
