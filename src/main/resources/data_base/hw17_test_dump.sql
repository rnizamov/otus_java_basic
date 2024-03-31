--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8
-- Dumped by pg_dump version 14.8

-- Started on 2024-03-31 22:50:23 UTC

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
-- TOC entry 216 (class 1259 OID 16565)
-- Name: answer; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.answer (
    id integer NOT NULL,
    answer text,
    istrue boolean,
    question_id integer
);


ALTER TABLE public.answer OWNER TO root;

--
-- TOC entry 215 (class 1259 OID 16564)
-- Name: answer_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.answer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.answer_id_seq OWNER TO root;

--
-- TOC entry 3391 (class 0 OID 0)
-- Dependencies: 215
-- Name: answer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.answer_id_seq OWNED BY public.answer.id;


--
-- TOC entry 210 (class 1259 OID 16512)
-- Name: group_test; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.group_test (
    id integer NOT NULL,
    group_name character varying(255)
);


ALTER TABLE public.group_test OWNER TO root;

--
-- TOC entry 209 (class 1259 OID 16511)
-- Name: group_test_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.group_test_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.group_test_id_seq OWNER TO root;

--
-- TOC entry 3392 (class 0 OID 0)
-- Dependencies: 209
-- Name: group_test_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.group_test_id_seq OWNED BY public.group_test.id;


--
-- TOC entry 214 (class 1259 OID 16533)
-- Name: question; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.question (
    id integer NOT NULL,
    question text,
    test_id integer
);


ALTER TABLE public.question OWNER TO root;

--
-- TOC entry 213 (class 1259 OID 16532)
-- Name: question_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.question_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_id_seq OWNER TO root;

--
-- TOC entry 3393 (class 0 OID 0)
-- Dependencies: 213
-- Name: question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.question_id_seq OWNED BY public.question.id;


--
-- TOC entry 212 (class 1259 OID 16519)
-- Name: test; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.test (
    id integer NOT NULL,
    test_name character varying(255),
    description text,
    level character varying(255),
    group_test_id integer
);


ALTER TABLE public.test OWNER TO root;

--
-- TOC entry 211 (class 1259 OID 16518)
-- Name: test_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.test_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.test_id_seq OWNER TO root;

--
-- TOC entry 3394 (class 0 OID 0)
-- Dependencies: 211
-- Name: test_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;


--
-- TOC entry 220 (class 1259 OID 16601)
-- Name: user_rating; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.user_rating (
    id integer NOT NULL,
    rating integer,
    user_id integer,
    test_id integer,
    answered_questions integer[]
);


ALTER TABLE public.user_rating OWNER TO root;

--
-- TOC entry 219 (class 1259 OID 16600)
-- Name: user_rating_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.user_rating_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_rating_id_seq OWNER TO root;

--
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 219
-- Name: user_rating_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.user_rating_id_seq OWNED BY public.user_rating.id;


--
-- TOC entry 218 (class 1259 OID 16592)
-- Name: users; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.users (
    id integer NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255)
);


ALTER TABLE public.users OWNER TO root;

--
-- TOC entry 217 (class 1259 OID 16591)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO root;

--
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3215 (class 2604 OID 16568)
-- Name: answer id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.answer ALTER COLUMN id SET DEFAULT nextval('public.answer_id_seq'::regclass);


--
-- TOC entry 3212 (class 2604 OID 16515)
-- Name: group_test id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.group_test ALTER COLUMN id SET DEFAULT nextval('public.group_test_id_seq'::regclass);


--
-- TOC entry 3214 (class 2604 OID 16536)
-- Name: question id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.question ALTER COLUMN id SET DEFAULT nextval('public.question_id_seq'::regclass);


--
-- TOC entry 3213 (class 2604 OID 16522)
-- Name: test id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 16604)
-- Name: user_rating id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.user_rating ALTER COLUMN id SET DEFAULT nextval('public.user_rating_id_seq'::regclass);


--
-- TOC entry 3216 (class 2604 OID 16595)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3381 (class 0 OID 16565)
-- Dependencies: 216
-- Data for Name: answer; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (1, 'Блок finally не выполнится только в одном случае - если вызвать System.exit(). 
', true, 1);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (2, 'не объявлять блок finally', false, 1);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (3, 'Оба класса имеют одинаковый API, но StringBuilder не синхронизирован', true, 3);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (4, 'Оба класса имеют одинаковый API, StringBuilder синхронизирован', false, 2);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (5, 'В специальную область памяти String pool.', true, 3);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (6, 'В специальную область памяти стек.', false, 3);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (7, 'Веб-браузер', false, 4);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (8, 'Selenium — это набор инструментов для автоматического веб-тестирования', true, 4);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (9, 'X-Path используется для поиска WebElement на веб-страницах. Это также полезно для идентификации динамических элементов.', true, 5);
INSERT INTO public.answer (id, answer, istrue, question_id) VALUES (10, 'X-Path не используется в Selenium', false, 5);


--
-- TOC entry 3375 (class 0 OID 16512)
-- Dependencies: 210
-- Data for Name: group_test; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.group_test (id, group_name) VALUES (1, 'java basic');
INSERT INTO public.group_test (id, group_name) VALUES (2, 'java pro');
INSERT INTO public.group_test (id, group_name) VALUES (3, 'spring');
INSERT INTO public.group_test (id, group_name) VALUES (4, 'java qa basic');
INSERT INTO public.group_test (id, group_name) VALUES (5, 'javaScript basic');


--
-- TOC entry 3379 (class 0 OID 16533)
-- Dependencies: 214
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.question (id, question, test_id) VALUES (1, 'Оператор try-catch-finally. Как избежать выполнения finally блока?', 1);
INSERT INTO public.question (id, question, test_id) VALUES (2, 'В чем отличие между классами StringBuffer и StringBuilder?', 1);
INSERT INTO public.question (id, question, test_id) VALUES (3, 'В какую часть памяти записываются литералы типа String?', 1);
INSERT INTO public.question (id, question, test_id) VALUES (4, 'Что такое Selenium?', 2);
INSERT INTO public.question (id, question, test_id) VALUES (5, 'Упомяните, для чего используется X-path?', 2);


--
-- TOC entry 3377 (class 0 OID 16519)
-- Dependencies: 212
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.test (id, test_name, description, level, group_test_id) VALUES (1, 'Java программирование', 'тест на знание основ java', 'junior', 1);
INSERT INTO public.test (id, test_name, description, level, group_test_id) VALUES (2, 'Selenium test', 'Знанием основ selenium', 'junior', 4);
INSERT INTO public.test (id, test_name, description, level, group_test_id) VALUES (3, 'Rest assured test', 'Знанием основ rest assured', 'junior', 4);


--
-- TOC entry 3385 (class 0 OID 16601)
-- Dependencies: 220
-- Data for Name: user_rating; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.user_rating (id, rating, user_id, test_id, answered_questions) VALUES (1, 5, 1, 1, '{1,2,3}');
INSERT INTO public.user_rating (id, rating, user_id, test_id, answered_questions) VALUES (2, 4, 1, 2, '{4}');


--
-- TOC entry 3383 (class 0 OID 16592)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.users (id, first_name, last_name, middle_name) VALUES (1, 'Rinat', 'Nizamov', 'Rustemovich');


--
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 215
-- Name: answer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.answer_id_seq', 10, true);


--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 209
-- Name: group_test_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.group_test_id_seq', 5, true);


--
-- TOC entry 3399 (class 0 OID 0)
-- Dependencies: 213
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.question_id_seq', 5, true);


--
-- TOC entry 3400 (class 0 OID 0)
-- Dependencies: 211
-- Name: test_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.test_id_seq', 3, true);


--
-- TOC entry 3401 (class 0 OID 0)
-- Dependencies: 219
-- Name: user_rating_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.user_rating_id_seq', 2, true);


--
-- TOC entry 3402 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- TOC entry 3225 (class 2606 OID 16572)
-- Name: answer answer_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pkey PRIMARY KEY (id);


--
-- TOC entry 3219 (class 2606 OID 16517)
-- Name: group_test group_test_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.group_test
    ADD CONSTRAINT group_test_pkey PRIMARY KEY (id);


--
-- TOC entry 3223 (class 2606 OID 16540)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- TOC entry 3221 (class 2606 OID 16526)
-- Name: test test_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


--
-- TOC entry 3229 (class 2606 OID 16608)
-- Name: user_rating user_rating_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.user_rating
    ADD CONSTRAINT user_rating_pkey PRIMARY KEY (id);


--
-- TOC entry 3227 (class 2606 OID 16599)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3232 (class 2606 OID 16573)
-- Name: answer answer_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.question(id);


--
-- TOC entry 3231 (class 2606 OID 16541)
-- Name: question question_test_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_test_id_fkey FOREIGN KEY (test_id) REFERENCES public.test(id);


--
-- TOC entry 3230 (class 2606 OID 16527)
-- Name: test test_group_test_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_group_test_id_fkey FOREIGN KEY (group_test_id) REFERENCES public.group_test(id);


--
-- TOC entry 3234 (class 2606 OID 16614)
-- Name: user_rating user_rating_test_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.user_rating
    ADD CONSTRAINT user_rating_test_id_fkey FOREIGN KEY (test_id) REFERENCES public.test(id);


--
-- TOC entry 3233 (class 2606 OID 16609)
-- Name: user_rating user_rating_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.user_rating
    ADD CONSTRAINT user_rating_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2024-03-31 22:50:24 UTC

--
-- PostgreSQL database dump complete
--

