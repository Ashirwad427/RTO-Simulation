INSERT INTO Owner (owner_id,token_id, v_id, first_name, last_name, address, b_date, phone_number)
VALUES 
    (101,1, NULL, 'Rahul', 'Sharma', '12/1, New Market', '1990-05-15', '9876543210'),
    (102,1, NULL, 'Priya', 'Patel', '34, Gandhi Road', '1985-09-22', '8765432109'),
    (103,1, NULL, 'Amit', 'Singh', '56, Surya Nagar', '1988-12-10', '7654321098'),
    (104,1, NULL, 'Sneha', 'Joshi', '78, Lake View Apartment', '1992-03-25', '6543210987'),
    (105,1, NULL, 'Neha', 'Kumar', '90, Raj Palace', '1995-07-18', '5432109876');

INSERT INTO Vehicle (vehicle_id, o_id, make, model, year, registration_date)
VALUES 
    (501, NULL, 'Maruti', 'Swift', 2020, '2020-01-15'),
    (503, NULL, 'Hyundai', 'i20', 2019, '2019-05-20'),
    (504, NULL, 'Tata', 'Nexon', 2018, '2018-09-10'),
    (507, NULL, 'Honda', 'City', 2021, '2021-03-28'),
    (508, NULL, 'Mahindra', 'XUV300', 2020, '2020-07-12'),
    (509, NULL, 'Toyota', 'Innova Crysta', 2017, '2017-11-05'),
    (511, NULL, 'Volkswagen', 'Polo', 2020, '2020-08-25'),
    (512, NULL, 'Maruti', 'Fronx', 2018, '2018-04-30'),
    (515, NULL, 'Tata', 'Harrier', 2021, '2021-10-03'),
    (516, NULL, 'Tata', 'Punch', 2022, '2022-01-22'),
    (519, NULL, 'Volkswagen', 'Virtus', 2019, '2019-12-08'),
    (520, NULL, 'Honda', 'Amaze', 2017, '2017-08-29');

update owner
set v_id=501 where owner_id=101 and token_id=1;
update owner
set v_id=507 where owner_id=102 and token_id=1;
update owner
set v_id=503 where owner_id=103 and token_id=1;
update owner
set v_id=504 where owner_id=104 and token_id=1;
update owner
set v_id=508 where owner_id=105 and token_id=1;

update vehicle
set o_id=101 where vehicle_id=501;
update vehicle
set o_id=102 where vehicle_id=507;
update vehicle
set o_id=103 where vehicle_id=503;
update vehicle
set o_id=104 where vehicle_id=504;
update vehicle
set o_id=105 where vehicle_id=508;

INSERT INTO Owner (owner_id,token_id, v_id, first_name, last_name, address, b_date, phone_number)
VALUES 
    (101,2, 515, 'Rahul', 'Sharma', '12/1, New Market', '1990-05-15', '9876543210'),
    (102,2, 520, 'Priya', 'Patel', '34, Gandhi Road', '1985-09-22', '8765432109'),
    (103,2, 512, 'Amit', 'Singh', '56, Surya Nagar', '1988-12-10', '7654321098'),
    (104,2, 509, 'Sneha', 'Joshi', '78, Lake View Apartment', '1992-03-25', '6543210987'),
    (105,2, 511, 'Neha', 'Kumar', '90, Raj Palace', '1995-07-18', '5432109876'),
    (101,3, 516, 'Rahul', 'Sharma', '12/1, New Market', '1990-05-15', '9876543210'),
    (103,3, 519, 'Amit', 'Singh', '56, Surya Nagar', '1988-12-10', '7654321098');

update vehicle
set o_id=101 where vehicle_id=515;
update vehicle
set o_id=102 where vehicle_id=520;
update vehicle
set o_id=103 where vehicle_id=512;
update vehicle
set o_id=104 where vehicle_id=509;
update vehicle
set o_id=105 where vehicle_id=511;
update vehicle
set o_id=101 where vehicle_id=516;
update vehicle
set o_id=103 where vehicle_id=519;

INSERT INTO Traffic_Fines (fine_id, veh_id, fine_amount, date_issued, violation_type, fine_status) VALUES 
(701, 501, 500.00, '2023-01-05', 'Speeding', 'CLEARED'),
(702, 503, 750.00, '2023-02-10', 'Parking', 'PENDING'),
(703, 509, 600.00, '2023-03-15', 'Red Light', 'PENDING'),
(704, 516, 1000.00, '2023-04-20', 'Seat Belt', 'CLEARED'),
(705, 512, 450.00, '2023-05-25', 'Speeding', 'PENDING'),
(706, 515, 800.00, '2023-06-30', 'Parking', 'CLEARED'),
(707, 501, 550.00, '2023-07-05', 'Red Light', 'CLEARED'),
(708, 503, 950.00, '2023-08-10', 'Seat Belt', 'CLEARED'),
(709, 509, 400.00, '2023-09-15', 'Speeding', 'PENDING'),
(710, 516, 700.00, '2023-10-20', 'Parking', 'CLEARED'),
(711, 512, 600.00, '2023-11-25', 'Red Light', 'PENDING'),
(712, 515, 850.00, '2023-12-30', 'Seat Belt', 'PENDING'),
(713, 501, 350.00, '2023-01-05', 'Speeding', 'PENDING'),
(714, 503, 900.00, '2023-02-10', 'Parking', 'PENDING'),
(715, 509, 700.00, '2023-03-15', 'Red Light', 'PENDING');

INSERT INTO Insurance_Policies (policy_id, vehi_id, insurance_company, policy_number, start_date, end_date, premium_amount) VALUES 
(301, 501, 'ICICI Lombard General Insurance', 'ICICI2024P1', '2024-01-01', '2025-01-01', 8000.00),
(302, 503, 'New India Assurance Company', 'NewIndia2024P1', '2024-02-01', '2025-02-01', 7000.00),
(303, 504, 'Oriental Insurance Company', 'Oriental2024P1', '2024-03-01', '2025-03-01', 9000.00),
(304, 507, 'United India Insurance Company', 'UnitedIndia2024P1', '2024-04-01', '2025-04-01', 7500.00),
(305, 508, 'National Insurance Company', 'National2024P1', '2024-05-01', '2025-05-01', 8500.00),
(306, 509, 'Bajaj Allianz General Insurance', 'Bajaj2024P1', '2024-06-01', '2025-06-01', 8200.00),
(307, 511, 'Reliance General Insurance', 'Reliance2024P1', '2024-07-01', '2025-07-01', 7800.00),
(308, 512, 'Tata AIG General Insurance', 'TataAIG2024P1', '2024-08-01', '2025-08-01', 8800.00),
(309, 515, 'HDFC ERGO General Insurance Company', 'HDFCERGO2024P1', '2024-09-01', '2025-09-01', 8300.00),
(310, 516, 'ICICI Lombard General Insurance', 'ICICI2024P2', '2024-10-01', '2025-10-01', 8200.00),
(311, 519, 'New India Assurance Company', 'NewIndia2024P2', '2024-11-01', '2025-11-01', 7500.00),
(312, 520, 'Oriental Insurance Company', 'Oriental2024P2', '2024-12-01', '2025-12-01', 9200.00);
