-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 02, 2023 lúc 04:40 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `spring_ecommerce`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand`
--

CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `brand`
--

INSERT INTO `brand` (`id`, `name`) VALUES
(1, 'Adidas'),
(2, 'Channel'),
(3, 'Puma');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Clothing'),
(2, 'Shoes'),
(3, 'HandBag');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `address`, `email`, `name`, `phone`) VALUES
(1, '1241 Tan Phong, Quan 7', 'sa@gmail.com', 'king lord', '124214144'),
(3, '88 Tan Phong, Quan 7', 'vanthao@gmail.com', 'tran van thao', '0942211156'),
(4, NULL, 'vanthao123@gmail.com', '', NULL),
(5, NULL, 'vanthao123@gmail.com', '', NULL),
(6, NULL, 'vanthao123@gmail.com', '', NULL),
(7, NULL, 'vanthao123@gmail.com', '', NULL),
(8, NULL, 'vanthao000009@gmail.com', '', NULL),
(9, NULL, 'vanthao000009@gmail.com', NULL, NULL),
(10, NULL, 'vanthao000009@gmail.com', NULL, NULL),
(11, NULL, 'vanthao000009@gmail.com', NULL, NULL),
(12, NULL, 'vanthao000009@gmail.com', NULL, NULL),
(13, NULL, 'vanthao123@gmail.com', NULL, NULL),
(14, NULL, 'vanthao123@gmail.com', NULL, NULL),
(15, NULL, 'vanthao123@gmail.com', NULL, NULL),
(16, NULL, 'vanthao123@gmail.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`id`, `date`, `total`, `customer_id`) VALUES
(12, '2023-03-31 20:23:51', 139.97, 3),
(13, '2023-03-31 20:35:38', 139.97, 3),
(14, '2023-03-31 20:46:26', 139.97, 3),
(15, '2023-03-31 21:53:01', 719.8399999999999, 3),
(16, '2023-04-01 14:11:30', 99.94999999999999, 3),
(17, '2023-04-01 21:48:21', 39.99, 3),
(18, '2023-04-01 21:48:37', NULL, 3),
(19, '2023-04-01 21:50:14', 19.99, 3),
(20, '2023-04-01 21:52:55', 39.99, 3),
(21, '2023-04-01 21:59:15', 119.97, 3),
(22, '2023-04-01 22:12:10', 39.99, 3),
(23, '2023-04-01 22:12:16', NULL, 3),
(24, '2023-04-01 22:12:18', NULL, 3),
(25, '2023-04-01 22:12:21', NULL, 3),
(26, '2023-04-01 22:16:01', NULL, 3),
(27, '2023-04-01 22:23:36', 39.99, 3),
(28, '2023-04-02 18:45:44', 299.95, 3),
(29, '2023-04-02 19:22:20', NULL, 3),
(30, '2023-04-02 19:23:33', 359.94, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_item`
--

CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order_item`
--

INSERT INTO `order_item` (`id`, `price`, `quantity`, `order_id`, `product_id`) VALUES
(7, 59.99, 2, 12, 2),
(8, 19.99, 1, 12, 1),
(9, 59.99, 2, 13, 2),
(10, 19.99, 1, 13, 1),
(11, 59.99, 2, 14, 2),
(12, 19.99, 1, 14, 1),
(13, 59.99, 10, 15, 2),
(14, 19.99, 6, 15, 1),
(15, 19.99, 5, 16, 1),
(16, 39.99, 1, 17, 3),
(17, 19.99, 1, 19, 1),
(18, 39.99, 1, 20, 3),
(19, 39.99, 1, 21, 6),
(20, 39.99, 2, 21, 3),
(21, 39.99, 1, 22, 3),
(22, 39.99, 1, 27, 6),
(23, 59.99, 5, 28, 2),
(24, 59.99, 6, 30, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `color`, `image`, `name`, `price`, `quantity`, `brand_id`, `category_id`) VALUES
(1, 'Red', 'product7.jpg', 'T-Shirt', 19.99, 26, 1, 1),
(2, 'Blue', 'product8.jpg', 'Sneakers', 59.99, 25, 2, 2),
(3, 'Black', 'product9.jpg', 'Jeans', 39.99, 55, 3, 1),
(4, 'Green', 'product10.jpg', 'Vallet', 39.99, 70, 2, 3),
(5, 'White', 'product11.jpg', 'Underwear', 39.99, 999, 2, 1),
(6, 'White', 'product12.jpg', 'Suite', 39.99, 999, 2, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `password`, `username`, `customer_id`) VALUES
(1, '123456', 'user1', 1),
(3, '123456', 'admin', 3),
(4, '123', 'test', 4),
(5, '123', 'thaopro1', 5),
(6, '123456', 'test123', 6),
(7, '123', 'admin123', 7),
(8, '123', 'admin112', 8),
(9, '123', 'vanthao1qqq', 9),
(10, '1234', 'adminsxxx', 10),
(11, '1234', 'adinsxxx', 11),
(12, '123', 'adminqx', 12),
(13, '123456', 'admin3xx', 13),
(14, '123456', 'admin3xxx', 14),
(15, '123456', 'admin3xxxx', 15),
(16, '123456', 'admin3xxxxx', 16);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1oduxyuuo3n2g98l3j7754vym` (`customer_id`);

--
-- Chỉ mục cho bảng `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs234mi6jususbx4b37k44cipy` (`order_id`),
  ADD KEY `FK551losx9j75ss5d6bfsqvijna` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdptx0i3ky01svofwjytq5iry0` (`customer_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `brand`
--
ALTER TABLE `brand`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `order_item`
--
ALTER TABLE `order_item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FKl70asp4l4w0jmbm1tqyofho4o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `FK1oduxyuuo3n2g98l3j7754vym` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Các ràng buộc cho bảng `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `FK551losx9j75ss5d6bfsqvijna` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKs234mi6jususbx4b37k44cipy` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKdptx0i3ky01svofwjytq5iry0` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
