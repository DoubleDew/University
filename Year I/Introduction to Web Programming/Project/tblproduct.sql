--
-- Table structure for table `tblproduct`
--

CREATE TABLE `tblproduct` (
  `id` int(8) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `image` text NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblproduct`
--

INSERT INTO `tblproduct` (`id`, `name`, `code`, `image`, `price`) VALUES
(1, 'Havit Keycaps Double Shot Backlit Pudding Keycap Set','caps-DOSH' 'images/1.jpeg' 18.00),
(2, 'Puith 60% Wooden Case', 'caseWO', 'images/case1.jpeg', 57.00),
(3, 'DZ60RGB V2 60% Mechanical Keyboard PCB', 'mec-KEPCB', 'images/pcb1.jpeg', 55.00),
(4, 'Matcha Dye Sub ZDA PBT Keycap', 'cap-ZDA', 'images/caps5.jpeg', 10.00);
(5, 'Mugen Apex Legends Custom Gaming Keycaps for Cherry MX Switches', 'cap-MUG', 'images/caps4.jpeg', 35.00)
(6, 'BAOD PBT Keycaps, Translucent Layer Mechanical Keyboard Keycap', 'cap-BAOD', 'images/caps3.jpeg', 33.00)
(7, 'TOFU Case 60% AluminumM E-WHITE', 'case-EW', 'images/case2.jpeg', 110.00)
(8, 'TOFU65 Acrylic Mechanical Keyboard Case', 'case-ACR65', 'images/case3.jpeg', 110.00)
(9, 'MELODY65', 'case-MEL', 'images/case4.jpeg', 300.00)
(10, 'Tecsee Oreo switches Mechanical Keyboard switches UHMWPE Stem PME Nylon Housing', 'switch-MEC-OR', 'images/s2.jpeg', 1.00)
(11, 'Cherry MX Blue Key Switches (10 Pcs)- MX1AG1NN', 'switch-MX-CHER', 'images/s3.jpeg', 10.00)
(12, 'ZugGear T1 Tactile Keyboard Switch, 67g Mechanical Key Switches (10 pcs)', 'switch-T1-MEC', 'images/s4.jpeg', 10.00)
(13, 'Fully Assembled Blade65 R2 Violet Purple With Badge Hot Swap Mechanical Keyboard With Cherry Profile Simple Purple Dye-sub Keycaps', 'keyb-SI-PUR', 'images/k1.jpeg', 309.00)
(14, 'Fully Assembled Blade65 R2 Gray With Badge Hot Swap Mechanical Keyboard With ePBT Gray&White ABS Keycaps', 'keyb-HOT-MEC', 'images/k2.jpeg', 328.00)
(15, 'Fully Assembled Blade65 R2 Pine Green With Badge Hot Swap Mechanical Keyboard With OSA Marrs Green PBT Keycaps', 'keyb-OSA-GRE', 'images/k3.jpeg', 420.00)

--
-- Indexes for table `tblproduct`
--
ALTER TABLE `tblproduct`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `product_code` (`code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblproduct`
--
ALTER TABLE `tblproduct`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;