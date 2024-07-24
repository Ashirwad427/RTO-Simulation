CREATE TABLE Owner (
    owner_id INT,
    token_id INT,
    v_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(255),
    b_date DATE,
    phone_number VARCHAR(10)
);


alter table Owner
add PRIMARY KEY(owner_id,token_id);


CREATE TABLE Vehicle (
    vehicle_id INT PRIMARY KEY,
    o_id INT,
    make VARCHAR(50),
    model VARCHAR(50),
    year INT,
    registration_date DATE,
    FOREIGN KEY (o_id) REFERENCES Owner(owner_id)
);

alter table Owner
add constraint fk_Vid FOREIGN KEY (v_id)
REFERENCES Vehicle(vehicle_id)
;

CREATE TABLE Traffic_Fines (
    fine_id INT PRIMARY KEY,
    veh_id INT,
    fine_amount DECIMAL(10, 2),
    date_issued DATE,
    violation_type VARCHAR(100),
    fine_status VARCHAR(20),
    FOREIGN KEY (veh_id) REFERENCES Vehicle(vehicle_id)
);

CREATE TABLE Insurance_Policies (
    policy_id INT PRIMARY KEY,
    vehi_id INT,
    insurance_company VARCHAR(100),
    policy_number VARCHAR(50),
    start_date DATE,
    end_date DATE,
    premium_amount DECIMAL(10, 2),
    FOREIGN KEY (vehi_id) REFERENCES Vehicle(vehicle_id)
);
