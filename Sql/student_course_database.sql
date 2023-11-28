PGDMP      -            
    {            student_course    16.0    16.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16669    student_course    DATABASE     �   CREATE DATABASE student_course WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Vietnamese_Vietnam.1258';
    DROP DATABASE student_course;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    16670    course    TABLE     X   CREATE TABLE public.course (
    id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.course;
       public         heap    postgres    false    4            �            1259    16673    course_id_seq    SEQUENCE     v   CREATE SEQUENCE public.course_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.course_id_seq;
       public          postgres    false    4    215            �           0    0    course_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.course_id_seq OWNED BY public.course.id;
          public          postgres    false    216            �            1259    16674    student    TABLE     �   CREATE TABLE public.student (
    student_id bigint NOT NULL,
    address character varying(255),
    birth_day character varying(255),
    email character varying(255),
    name character varying(255),
    phone_number character varying(255)
);
    DROP TABLE public.student;
       public         heap    postgres    false    4            �            1259    16679    student_course    TABLE     f   CREATE TABLE public.student_course (
    course_id bigint NOT NULL,
    student_id bigint NOT NULL
);
 "   DROP TABLE public.student_course;
       public         heap    postgres    false    4            �            1259    16682    student_student_id_seq    SEQUENCE        CREATE SEQUENCE public.student_student_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.student_student_id_seq;
       public          postgres    false    217    4            �           0    0    student_student_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.student_student_id_seq OWNED BY public.student.student_id;
          public          postgres    false    219            #           2604    16683 	   course id    DEFAULT     f   ALTER TABLE ONLY public.course ALTER COLUMN id SET DEFAULT nextval('public.course_id_seq'::regclass);
 8   ALTER TABLE public.course ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            $           2604    16684    student student_id    DEFAULT     x   ALTER TABLE ONLY public.student ALTER COLUMN student_id SET DEFAULT nextval('public.student_student_id_seq'::regclass);
 A   ALTER TABLE public.student ALTER COLUMN student_id DROP DEFAULT;
       public          postgres    false    219    217            �          0    16670    course 
   TABLE DATA           *   COPY public.course (id, name) FROM stdin;
    public          postgres    false    215          �          0    16674    student 
   TABLE DATA           \   COPY public.student (student_id, address, birth_day, email, name, phone_number) FROM stdin;
    public          postgres    false    217   b       �          0    16679    student_course 
   TABLE DATA           ?   COPY public.student_course (course_id, student_id) FROM stdin;
    public          postgres    false    218   �       �           0    0    course_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.course_id_seq', 1, false);
          public          postgres    false    216            �           0    0    student_student_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.student_student_id_seq', 1, true);
          public          postgres    false    219            &           2606    16686    course course_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.course DROP CONSTRAINT course_pkey;
       public            postgres    false    215            (           2606    16688    student student_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (student_id);
 >   ALTER TABLE ONLY public.student DROP CONSTRAINT student_pkey;
       public            postgres    false    217            )           2606    16689 *   student_course fkejrkh4gv8iqgmspsanaji90ws    FK CONSTRAINT     �   ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT fkejrkh4gv8iqgmspsanaji90ws FOREIGN KEY (course_id) REFERENCES public.course(id);
 T   ALTER TABLE ONLY public.student_course DROP CONSTRAINT fkejrkh4gv8iqgmspsanaji90ws;
       public          postgres    false    4646    215    218            *           2606    16694 *   student_course fkq7yw2wg9wlt2cnj480hcdn6dq    FK CONSTRAINT     �   ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT fkq7yw2wg9wlt2cnj480hcdn6dq FOREIGN KEY (student_id) REFERENCES public.student(student_id);
 T   ALTER TABLE ONLY public.student_course DROP CONSTRAINT fkq7yw2wg9wlt2cnj480hcdn6dq;
       public          postgres    false    218    4648    217            �   Q   x�3��J,KTpJL�N�K�2��(���2��'e�p�p:+s�r:kks�qT�d��q�s:��g�pYp�p��qqq <ZM      �   E  x�m��N�0���S�	�q{�������Ŕ*� Ft�k�eCb@*S;0$�=�&��*	�:٧�w��s����ҳ��n�rI�tĵ����b���Y���$/MqיT%���� ۴_��/Ls.b<�h����c��Y*��T.�;"5��7sG{�'�gH���JbY��k"�8(~6u�֔H�ݬ�=j�g���aR�� ��m�/�4�#���3e���9~�>;ڭWthJ`2����$�^����U�E� �d��Y��0}�n�s��d %�����p��H����ne\��r.}����^�攩T�I���!����C      �      x�3�4����� ]     