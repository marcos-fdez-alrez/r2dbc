DROP TABLE IF EXISTS policy;
CREATE TABLE policy (id SERIAL PRIMARY KEY, policy_number VARCHAR(10) , year DATE, currency VARCHAR(3), assured_amount DOUBLE);