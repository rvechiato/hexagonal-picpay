CREATE TABLE tb_users(
    id UUID PRIMARY KEY,
    email VARCHAR(70) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    tax_number VARCHAR(15) NOT NULL,
    full_name VARCHAR(70) NOT NULL,
    user_type VARCHAR(30) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPs
)