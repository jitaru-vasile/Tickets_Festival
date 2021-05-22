--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-13 23:13:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 32330)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    id character varying(255) NOT NULL,
    apartment character varying(255),
    building character varying(255),
    city character varying(255),
    floor character varying(255),
    house_hold_number character varying(255),
    street character varying(255)
);


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 32338)
-- Name: festival_ticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.festival_ticket (
    id character varying(255) NOT NULL,
    end_date date,
    name character varying(255),
    price integer,
    start_date date,
    type character varying(255),
    user_transaction_id character varying(255)
);


ALTER TABLE public.festival_ticket OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32346)
-- Name: user_profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_profile (
    id character varying(255) NOT NULL,
    birth_date date,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    permission boolean,
    address_id character varying(255)
);


ALTER TABLE public.user_profile OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 32354)
-- Name: user_transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_transaction (
    id character varying(255) NOT NULL,
    no_of_tickets integer,
    user_profilet_id character varying(255),
    ticket_id character varying(255)
);


ALTER TABLE public.user_transaction OWNER TO postgres;

--
-- TOC entry 3006 (class 0 OID 32330)
-- Dependencies: 200
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('93f5ac96-434a-4bbf-8a40-6756c890035a', '324', '4f', 'Vadu Izei', 'sdfsd', '12', 'Str. Sugaului 131,com. Vadu Izei, jud. Maramures, Romania');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('57232fb7-0c5d-42ee-9d58-e0f7dbb055fs', 'admin', 'admin', 'admin', '2', 'admin', 'admin');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('57232fb7-0c5d-42ee-9d58-e0f7dbb0558e', '32', '4f', 'Sighetu Marmatiei', '342', '12', 'Str. Sugaului 131,com. Vadu Izei, jud. Maramures, Romania');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('defc122f-ed12-48a8-ab84-a37486b76bd5', '', '', '', '', '', '');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('2ec7d342-27a5-4000-a658-df532457ce62', '324', '4f', 'Vadu Izei', 'sdfsd', '12', 'Baciu');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('696d285d-93cc-4fc5-b97a-8ebaea722131', 'sdsa', 'test', 'asdas', 'test', '131', 'SHyhsd');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('0300d3ea-f4bc-4567-9e97-03fa16c94bb5', '34', '543', 'Vadu Izei', '34', '3', 'Str. Sugaului 131,com. Vadu Izei, jud. Maramures, Romania');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('af4f1f25-fa60-440d-9592-8331a22510d3', 'sdfs', 'sdfsd', 'Vadu Izei', 'sdf', '12', 'Str. Sugaului 131,com. Vadu Izei, jud. Maramures, Romania');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('ecc90d7d-cebd-43fd-b54d-8ef78981c8c1', 'sad', 'sad', 'Vadu Izei', 'asd', '12', 'Str. Sugaului 131,com. Vadu Izei, jud. Maramures, Romania');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('acb38872-ce13-430b-8c66-a7057c9e1690', 'dafad', 'sdfsdf', 'Vadu Izei', 'sfdd', '12', 'Str. Sugaului 131,com. Vadu Izei, jud. Maramures, Romania');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('487f1203-9fc9-4d1d-95d7-7b9f9f8e9944', 'dsf', 'sdf', 'Vadu Izei', 'sdf', '131', 'Str. Sugaului 131,com. Vadu Izei, jud. Maramures, Romania');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('d0c74da7-e9d6-478a-86b3-8eae7a9b60cc', 'sad', 'sda', 'sad', 'sda', 'sad', 'asd');
INSERT INTO public.address (id, apartment, building, city, floor, house_hold_number, street) VALUES ('0fbe151f-c7bd-46f8-9220-c83f34b66f4d', 'sdf', 'sdfs', 'sfd', 'sdf', 'sdf', 'sdfs');


--
-- TOC entry 3007 (class 0 OID 32338)
-- Dependencies: 201
-- Data for Name: festival_ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.festival_ticket (id, end_date, name, price, start_date, type, user_transaction_id) VALUES ('4bd00457-f8fc-48bb-a8b8-2fede8732c89', '2021-04-25', 'Super dupper ticket', 500, '2021-04-23', 'Super dupper ticket', NULL);
INSERT INTO public.festival_ticket (id, end_date, name, price, start_date, type, user_transaction_id) VALUES ('31ba6991-3c48-4ecf-84e6-952fcaaea678', '2021-04-22', 'Ticket smeker', 500, '2021-04-24', 'Mega Ticket', NULL);
INSERT INTO public.festival_ticket (id, end_date, name, price, start_date, type, user_transaction_id) VALUES ('65adb8d2-88fe-484a-ae83-36db8a37963e', '2021-04-11', 'VIP TICKET', 150, '2021-04-01', 'VIP TICKET', NULL);
INSERT INTO public.festival_ticket (id, end_date, name, price, start_date, type, user_transaction_id) VALUES ('aa316bdf-cfbd-48d6-97b4-2650262d1682', '2021-04-30', 'Ticket Cool', 10000, '2021-04-01', 'Ticket Cool', NULL);
INSERT INTO public.festival_ticket (id, end_date, name, price, start_date, type, user_transaction_id) VALUES ('1e55ae4f-7b57-48cf-8b64-1662856a296a', '2021-04-25', 'Ticket3', 500, '2021-04-15', 'Ticket okish', NULL);


--
-- TOC entry 3008 (class 0 OID 32346)
-- Dependencies: 202
-- Data for Name: user_profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('af09b97d-ac75-4e17-bb6e-935d46d57deb', '2021-04-08', 'andrei.jitaru@hpm.ro', 'JItaru ', 'Andrei', 'elev1Aa.', false, '93f5ac96-434a-4bbf-8a40-6756c890035a');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('104ca0db-f287-430f-8b21-3ec65a325971', '2002-02-02', 'admin@admin.com', 'admin', 'admin', 'elev1Aa.', true, '57232fb7-0c5d-42ee-9d58-e0f7dbb055fs');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('3ea02ac9-8669-4a1d-b124-bee216ac92f7', '2021-04-02', 'jitaruvasile77@yahoo.com', 'Jitaru', 'Vasile', 'elev1Aa.', false, '57232fb7-0c5d-42ee-9d58-e0f7dbb0558e');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('53dcc930-f6ed-4727-a1dc-351729110f9a', '2000-09-26', 'calinana13@gmail.com', 'Calin', 'Ale', 'elev1Aa.', false, '2ec7d342-27a5-4000-a658-df532457ce62');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('0d288f52-bf4d-4ea6-aecf-b066cf674f64', '2021-04-02', 'tusfjds@hsahsa.com', 'Tufisi', 'Radu', 'elev1Aa.', false, '696d285d-93cc-4fc5-b97a-8ebaea722131');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('dea7624c-fba3-448b-88c0-356287a24968', '2021-05-13', 'jitaruvasile77@fsds.com', 'Jitaru', 'Vasile', 'elev1Aa.', false, '0300d3ea-f4bc-4567-9e97-03fa16c94bb5');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('3fe3731f-2bf9-4752-8b56-4cffd75694ea', '2021-05-06', 'jitaruvasile77@yahoo.com', 'Jitaru', 'Vasile', 'asdas', false, 'ecc90d7d-cebd-43fd-b54d-8ef78981c8c1');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('d5e7f22c-fefd-4ab7-8fc3-b17993e9197a', '2021-05-22', 'andrei.jitaru@blavb.com', 'Andrei', 'BlaBla', '334234', false, 'acb38872-ce13-430b-8c66-a7057c9e1690');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('7a0fb0e0-80bc-4fd1-b96c-6a249765348f', '2021-05-22', 'sdksdk@ahsha.oc', 'sdfs', 'sdf', 'asdd', false, '487f1203-9fc9-4d1d-95d7-7b9f9f8e9944');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('7f7dbb2a-252f-42a5-9175-32bdf0969185', '2021-05-20', 'asdsa@yahoo.com', 'asdas', 'asasd', 'ads', false, 'd0c74da7-e9d6-478a-86b3-8eae7a9b60cc');
INSERT INTO public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) VALUES ('0992e85f-7823-4e14-83d9-913caf5f6720', '2021-05-20', 'igor.budescu@yahoo.com', 'Igor', 'Budescu', 'elev1Aa,', false, '0fbe151f-c7bd-46f8-9220-c83f34b66f4d');


--
-- TOC entry 3009 (class 0 OID 32354)
-- Dependencies: 203
-- Data for Name: user_transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('ec814903-b31b-49c5-a8f6-544beca0429d', 8, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('7df648f1-95ee-4542-8e9a-11766e0bb02a', 7, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('9d6568f9-2539-4290-993d-2e2cf8bdfbd6', 1, '53dcc930-f6ed-4727-a1dc-351729110f9a', 'aa316bdf-cfbd-48d6-97b4-2650262d1682');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('1c639618-fa4e-4422-9b4d-9e4681202741', 1, '53dcc930-f6ed-4727-a1dc-351729110f9a', '1e55ae4f-7b57-48cf-8b64-1662856a296a');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('eed381e1-ecbf-4e39-aee8-eb13d225aabf', 1, 'af09b97d-ac75-4e17-bb6e-935d46d57deb', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('f04e56ce-aa20-4a3d-9da7-c6dee0b2cf8b', 1, 'af09b97d-ac75-4e17-bb6e-935d46d57deb', '65adb8d2-88fe-484a-ae83-36db8a37963e');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('f2f1cf78-3c77-47cc-be6e-68170642c33f', 5, '0d288f52-bf4d-4ea6-aecf-b066cf674f64', '65adb8d2-88fe-484a-ae83-36db8a37963e');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('5efc3be1-07b0-4d9e-9405-02d69ba45d39', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('e91c8f58-859e-4dfb-9532-f1d4463156a4', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('fe922dc5-6642-4814-b990-5a187b1d2f03', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('934653b2-6113-4469-b92b-7746c1e75834', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', 'aa316bdf-cfbd-48d6-97b4-2650262d1682');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('4f7b0150-ccf1-43b4-a1aa-d26d008d58e7', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '1e55ae4f-7b57-48cf-8b64-1662856a296a');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('e712a143-fecb-422b-9c8c-264622b04f96', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('364926be-926c-48ac-83ea-62e34b9de07b', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('061adade-af68-4664-8101-cbb349b43842', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('155ca405-28cd-4735-8f06-b3e970de0f98', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('65f1c88c-dd32-4ee4-a94b-749177b85be3', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('fb001a60-a2e4-4762-a4bd-6729482ff6a4', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('a99edfa7-6612-463d-98ec-f12ab86f873a', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('235f6b6a-2b0c-4380-8db9-71b6d00ea790', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('d22b0c3f-92d6-410d-a3b1-788e0f55f08d', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', 'aa316bdf-cfbd-48d6-97b4-2650262d1682');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('fa694417-59dd-44e0-858d-43c13b3bdf43', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('36f5d226-c3ba-4336-b541-ec2994143a30', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '65adb8d2-88fe-484a-ae83-36db8a37963e');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('bf5512e5-b520-4f3e-a807-ccef6c6f45cd', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('781b6333-a3aa-4ec0-b6bd-8a156555adcf', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '65adb8d2-88fe-484a-ae83-36db8a37963e');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('477c8344-9e5e-46bc-89f8-8dcac68308cb', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '1e55ae4f-7b57-48cf-8b64-1662856a296a');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('3f607273-038a-4b6f-b4ed-ef6fcbb5f03b', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('3766165d-9059-4de3-82ca-ce5be609dfc7', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '65adb8d2-88fe-484a-ae83-36db8a37963e');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('39b85c85-85e1-488d-a7b3-b26f889dfdec', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('1866403d-76f7-4215-8e1d-153f1f6d192b', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('ae6b7153-b728-4e10-b264-48094ce711cb', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('72c37d1a-ce60-4e74-9ea1-3296ceaee3a8', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('32d12bc9-f3fe-42ff-b6c7-c698493b2e63', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('129aa155-0ce4-467d-8a17-81bdc81ba601', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('7740722a-1dfc-4bfd-af03-efd9cb900157', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('b194c328-a16b-4d2a-95ef-2e772153deb7', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('e01eb3d2-428d-4e8a-a978-886803a46275', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('b6876e6b-b1dd-4e2d-ad46-b3f45f8ff281', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('82fd598d-5fa5-4c19-9995-44bbc827fb2b', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('ae1c5b9b-6698-4016-9df4-49649c31dd07', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('a19709a8-a7b4-44fa-9cf5-60f1065d5a0c', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('82eeabfa-e8c2-454b-bafb-dbbc4f493486', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('ce707295-5480-4ce5-bd52-2e978d0a93a1', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '65adb8d2-88fe-484a-ae83-36db8a37963e');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('10a8a110-7932-48ca-adb4-0ce330f45d81', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '65adb8d2-88fe-484a-ae83-36db8a37963e');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('35b6b7a2-9620-42f9-9df7-bdc48a78c127', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', 'aa316bdf-cfbd-48d6-97b4-2650262d1682');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('a10aea04-fa15-425f-ab77-bae3ceb3d44a', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('7e2cf445-1c0c-4227-bf88-540f0ed86a2d', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('34e1585e-5889-47d9-885b-0ed45a963b2f', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '1e55ae4f-7b57-48cf-8b64-1662856a296a');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('37056ada-1320-4641-907c-8c048b925e4b', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '4bd00457-f8fc-48bb-a8b8-2fede8732c89');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('8d78e663-ff50-4129-89c1-3f904152ad23', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', 'aa316bdf-cfbd-48d6-97b4-2650262d1682');
INSERT INTO public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) VALUES ('3a0c6e18-6549-40cf-ba73-5e12ca7afd01', 1, '3ea02ac9-8669-4a1d-b124-bee216ac92f7', '31ba6991-3c48-4ecf-84e6-952fcaaea678');


--
-- TOC entry 2865 (class 2606 OID 32337)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 2867 (class 2606 OID 32345)
-- Name: festival_ticket festival_ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.festival_ticket
    ADD CONSTRAINT festival_ticket_pkey PRIMARY KEY (id);


--
-- TOC entry 2869 (class 2606 OID 32353)
-- Name: user_profile user_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_profile
    ADD CONSTRAINT user_profile_pkey PRIMARY KEY (id);


--
-- TOC entry 2871 (class 2606 OID 32361)
-- Name: user_transaction user_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_transaction
    ADD CONSTRAINT user_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 2872 (class 2606 OID 32362)
-- Name: festival_ticket fk2y2545uu2o7ira5dvelk7wepw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.festival_ticket
    ADD CONSTRAINT fk2y2545uu2o7ira5dvelk7wepw FOREIGN KEY (user_transaction_id) REFERENCES public.user_transaction(id);


--
-- TOC entry 2874 (class 2606 OID 32372)
-- Name: user_transaction fk4nr5c9cbq59r2wwpqpqpypiu8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_transaction
    ADD CONSTRAINT fk4nr5c9cbq59r2wwpqpqpypiu8 FOREIGN KEY (user_profilet_id) REFERENCES public.user_profile(id);


--
-- TOC entry 2875 (class 2606 OID 35583)
-- Name: user_transaction fke2slw0wk0ogvsdyyu1qxocrhh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_transaction
    ADD CONSTRAINT fke2slw0wk0ogvsdyyu1qxocrhh FOREIGN KEY (ticket_id) REFERENCES public.festival_ticket(id);


--
-- TOC entry 2873 (class 2606 OID 32367)
-- Name: user_profile fkt7ck1erxe5phbhrdk1cn92h52; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_profile
    ADD CONSTRAINT fkt7ck1erxe5phbhrdk1cn92h52 FOREIGN KEY (address_id) REFERENCES public.address(id);


-- Completed on 2021-05-13 23:13:28

--
-- PostgreSQL database dump complete
--

