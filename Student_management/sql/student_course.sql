--
-- PostgreSQL database cluster dump
--

-- Started on 2023-12-04 10:43:59

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2023-12-04 10:43:59

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

-- Completed on 2023-12-04 10:43:59

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2023-12-04 10:43:59

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

--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 4778 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


-- Completed on 2023-12-04 10:44:00

--
-- PostgreSQL database dump complete
--

--
-- Database "student_course" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2023-12-04 10:44:00

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

--
-- TOC entry 4804 (class 1262 OID 16572)
-- Name: student_course; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE student_course WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE student_course OWNER TO postgres;

\connect student_course

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
-- TOC entry 216 (class 1259 OID 16574)
-- Name: course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course (
    course_id integer NOT NULL,
    course_name character varying(255)
);


ALTER TABLE public.course OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16573)
-- Name: course_course_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.course_course_id_seq OWNER TO postgres;

--
-- TOC entry 4805 (class 0 OID 0)
-- Dependencies: 215
-- Name: course_course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_course_id_seq OWNED BY public.course.course_id;


--
-- TOC entry 218 (class 1259 OID 16581)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    student_id integer NOT NULL,
    student_address character varying(255),
    student_birth_day character varying(255),
    student_email character varying(255),
    status boolean,
    student_name character varying(255),
    student_phone character varying(255)
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16589)
-- Name: student_course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student_course (
    student_id integer NOT NULL,
    course_id integer NOT NULL
);


ALTER TABLE public.student_course OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16580)
-- Name: student_student_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.student_student_id_seq OWNER TO postgres;

--
-- TOC entry 4806 (class 0 OID 0)
-- Dependencies: 217
-- Name: student_student_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_student_id_seq OWNED BY public.student.student_id;


--
-- TOC entry 4643 (class 2604 OID 16577)
-- Name: course course_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course ALTER COLUMN course_id SET DEFAULT nextval('public.course_course_id_seq'::regclass);


--
-- TOC entry 4644 (class 2604 OID 16584)
-- Name: student student_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN student_id SET DEFAULT nextval('public.student_student_id_seq'::regclass);


--
-- TOC entry 4795 (class 0 OID 16574)
-- Dependencies: 216
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course (course_id, course_name) FROM stdin;
2	C#
3	Python
4	Node Js
5	Html
6	Java
1	Java Script
\.


--
-- TOC entry 4797 (class 0 OID 16581)
-- Dependencies: 218
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student (student_id, student_address, student_birth_day, student_email, status, student_name, student_phone) FROM stdin;
1	Hà Nam	25/09/1997	vuhieuminh2597@gmail.com	f	Vũ Minh Hiếu	0966916002
2	Thanh Hóa	16/09/1980	phamtuyen80@gmail.com	f	Phạm Văn Tuyến	0214216654
3	Nghệ An	05/01/1992	namElsu@gmail.com	f	Nguyễn Bá nam	1600545115
\.


--
-- TOC entry 4798 (class 0 OID 16589)
-- Dependencies: 219
-- Data for Name: student_course; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student_course (student_id, course_id) FROM stdin;
1	1
2	1
\.


--
-- TOC entry 4807 (class 0 OID 0)
-- Dependencies: 215
-- Name: course_course_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_course_id_seq', 5, true);


--
-- TOC entry 4808 (class 0 OID 0)
-- Dependencies: 217
-- Name: student_student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_student_id_seq', 3, true);


--
-- TOC entry 4646 (class 2606 OID 16579)
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (course_id);


--
-- TOC entry 4648 (class 2606 OID 16588)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (student_id);


--
-- TOC entry 4649 (class 2606 OID 16592)
-- Name: student_course fkejrkh4gv8iqgmspsanaji90ws; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT fkejrkh4gv8iqgmspsanaji90ws FOREIGN KEY (course_id) REFERENCES public.course(course_id);


--
-- TOC entry 4650 (class 2606 OID 16597)
-- Name: student_course fkq7yw2wg9wlt2cnj480hcdn6dq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT fkq7yw2wg9wlt2cnj480hcdn6dq FOREIGN KEY (student_id) REFERENCES public.student(student_id);


-- Completed on 2023-12-04 10:44:00

--
-- PostgreSQL database dump complete
--

-- Completed on 2023-12-04 10:44:00

--
-- PostgreSQL database cluster dump complete
--

