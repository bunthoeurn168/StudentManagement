PGDMP                         {            scoremanagement    14.2    14.2      ,           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            -           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            .           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            /           1262    246419    scoremanagement    DATABASE     s   CREATE DATABASE scoremanagement WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE scoremanagement;
                postgres    false                        3079    246423 	   uuid-ossp 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
    DROP EXTENSION "uuid-ossp";
                   false            0           0    0    EXTENSION "uuid-ossp"    COMMENT     W   COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';
                        false    2            �            1259    246450 	   tblcourse    TABLE     �   CREATE TABLE public.tblcourse (
    course_id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    course_name character varying NOT NULL,
    description character varying NOT NULL
);
    DROP TABLE public.tblcourse;
       public         heap    postgres    false    2            �            1259    246508    tbllogin    TABLE     �   CREATE TABLE public.tbllogin (
    log_id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    log_username character varying NOT NULL,
    log_password character varying NOT NULL
);
    DROP TABLE public.tbllogin;
       public         heap    postgres    false    2            �            1259    246482    tblregister    TABLE     �   CREATE TABLE public.tblregister (
    reg_id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    stud_id uuid,
    subject_id uuid,
    course_id uuid,
    school_yr_id uuid,
    skill_id uuid
);
    DROP TABLE public.tblregister;
       public         heap    postgres    false    2            �            1259    246442    tblschoolyear    TABLE     �   CREATE TABLE public.tblschoolyear (
    school_yr_id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    school_yr integer NOT NULL
);
 !   DROP TABLE public.tblschoolyear;
       public         heap    postgres    false    2            �            1259    246528    tblskill    TABLE     �   CREATE TABLE public.tblskill (
    skill_id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    skill_name character varying NOT NULL
);
    DROP TABLE public.tblskill;
       public         heap    postgres    false    2            �            1259    246434 
   tblstudent    TABLE     �  CREATE TABLE public.tblstudent (
    stud_id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    fullname character varying NOT NULL,
    gender character varying NOT NULL,
    address character varying,
    telephone character varying NOT NULL,
    email character varying NOT NULL,
    shift character varying NOT NULL,
    course_name character varying,
    subject_name character varying,
    school_yr character varying,
    skill_name character varying,
    stud_no character varying
);
    DROP TABLE public.tblstudent;
       public         heap    postgres    false    2            �            1259    246458 
   tblsubject    TABLE     �   CREATE TABLE public.tblsubject (
    subject_id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    subject_name character varying NOT NULL
);
    DROP TABLE public.tblsubject;
       public         heap    postgres    false    2            %          0    246450 	   tblcourse 
   TABLE DATA           H   COPY public.tblcourse (course_id, course_name, description) FROM stdin;
    public          postgres    false    212   �%       (          0    246508    tbllogin 
   TABLE DATA           F   COPY public.tbllogin (log_id, log_username, log_password) FROM stdin;
    public          postgres    false    215   �&       '          0    246482    tblregister 
   TABLE DATA           e   COPY public.tblregister (reg_id, stud_id, subject_id, course_id, school_yr_id, skill_id) FROM stdin;
    public          postgres    false    214   '       $          0    246442    tblschoolyear 
   TABLE DATA           @   COPY public.tblschoolyear (school_yr_id, school_yr) FROM stdin;
    public          postgres    false    211   '       )          0    246528    tblskill 
   TABLE DATA           8   COPY public.tblskill (skill_id, skill_name) FROM stdin;
    public          postgres    false    216   �'       #          0    246434 
   tblstudent 
   TABLE DATA           �   COPY public.tblstudent (stud_id, fullname, gender, address, telephone, email, shift, course_name, subject_name, school_yr, skill_name, stud_no) FROM stdin;
    public          postgres    false    210   "(       &          0    246458 
   tblsubject 
   TABLE DATA           >   COPY public.tblsubject (subject_id, subject_name) FROM stdin;
    public          postgres    false    213   )       �           2606    246457    tblcourse tblcourse_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tblcourse
    ADD CONSTRAINT tblcourse_pkey PRIMARY KEY (course_id);
 B   ALTER TABLE ONLY public.tblcourse DROP CONSTRAINT tblcourse_pkey;
       public            postgres    false    212            �           2606    246515    tbllogin tbllogin_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tbllogin
    ADD CONSTRAINT tbllogin_pkey PRIMARY KEY (log_id);
 @   ALTER TABLE ONLY public.tbllogin DROP CONSTRAINT tbllogin_pkey;
       public            postgres    false    215            �           2606    246487    tblregister tblregister_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tblregister
    ADD CONSTRAINT tblregister_pkey PRIMARY KEY (reg_id);
 F   ALTER TABLE ONLY public.tblregister DROP CONSTRAINT tblregister_pkey;
       public            postgres    false    214            �           2606    246449     tblschoolyear tblschoolyear_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tblschoolyear
    ADD CONSTRAINT tblschoolyear_pkey PRIMARY KEY (school_yr_id);
 J   ALTER TABLE ONLY public.tblschoolyear DROP CONSTRAINT tblschoolyear_pkey;
       public            postgres    false    211            �           2606    246535    tblskill tblskill_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tblskill
    ADD CONSTRAINT tblskill_pkey PRIMARY KEY (skill_id);
 @   ALTER TABLE ONLY public.tblskill DROP CONSTRAINT tblskill_pkey;
       public            postgres    false    216            �           2606    246441    tblstudent tblstudent_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tblstudent
    ADD CONSTRAINT tblstudent_pkey PRIMARY KEY (stud_id);
 D   ALTER TABLE ONLY public.tblstudent DROP CONSTRAINT tblstudent_pkey;
       public            postgres    false    210            �           2606    246465    tblsubject tblsubject_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tblsubject
    ADD CONSTRAINT tblsubject_pkey PRIMARY KEY (subject_id);
 D   ALTER TABLE ONLY public.tblsubject DROP CONSTRAINT tblsubject_pkey;
       public            postgres    false    213            �           2606    246498    tblregister fk_course    FK CONSTRAINT     �   ALTER TABLE ONLY public.tblregister
    ADD CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES public.tblcourse(course_id);
 ?   ALTER TABLE ONLY public.tblregister DROP CONSTRAINT fk_course;
       public          postgres    false    214    212    3210            �           2606    246536    tblregister fk_skill    FK CONSTRAINT     }   ALTER TABLE ONLY public.tblregister
    ADD CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES public.tblskill(skill_id);
 >   ALTER TABLE ONLY public.tblregister DROP CONSTRAINT fk_skill;
       public          postgres    false    3218    216    214            �           2606    246488    tblregister fk_student    FK CONSTRAINT        ALTER TABLE ONLY public.tblregister
    ADD CONSTRAINT fk_student FOREIGN KEY (stud_id) REFERENCES public.tblstudent(stud_id);
 @   ALTER TABLE ONLY public.tblregister DROP CONSTRAINT fk_student;
       public          postgres    false    214    210    3206            �           2606    246493    tblregister fk_subject    FK CONSTRAINT     �   ALTER TABLE ONLY public.tblregister
    ADD CONSTRAINT fk_subject FOREIGN KEY (subject_id) REFERENCES public.tblsubject(subject_id);
 @   ALTER TABLE ONLY public.tblregister DROP CONSTRAINT fk_subject;
       public          postgres    false    213    214    3212            �           2606    246503    tblregister fk_year    FK CONSTRAINT     �   ALTER TABLE ONLY public.tblregister
    ADD CONSTRAINT fk_year FOREIGN KEY (school_yr_id) REFERENCES public.tblschoolyear(school_yr_id);
 =   ALTER TABLE ONLY public.tblregister DROP CONSTRAINT fk_year;
       public          postgres    false    211    3208    214            %   �   x��ͽj�0��ٺ
��1��߽Эt����H�1M� �-���d
:/ϧx��<�m9@���"�����}�2U<��e꾎s�T�ڲl떮c�V��$/�R�Eb�Ņr/*tz�M�4:�xP|�-�x�>��W��?��x�,�	\�!'�F�|"�ur�{�x9��[n�xI�A����B� �L[�      (   h   x�-�11@�:�; :���!�h�����q������;B�a��t�5#k��z/��g9{jH���I�8�1p� �K�����|����z�j�BqD      '      x������ � �      $   v   x����E!@�G/�#��L���0�w)�L�e�ܕk�Zξ��#�gϚ8�x��bH�0�����@�:�8�����;�e��R��c��fBae��jϢn�ɡ��? ��y'�      )   n   x����  PM�%;��YY?9�j��߽T��kÔp�1�s#�����|Z9? ���NrA]�0L7.��#�R�rd^���9ۦ�m�@ͬ�#I�;s�6+�s_�}��~!�      #   �   x�m�;N�0���zـG���vҀEJJ��GrlK&b�$����H��?a&�9C*'�h�[����NJx�j��0zS�`Zn�y8��X�E�vRi��0G\���n��5�����\�_��S՗<��8<Z��i���'�6uR����Ռj�e�8!��G��<�xB��q��u����V�$x�����3~����?}A�.��o�)Pc      &   �   x�U�;n�0 ��:�/�@��Ƣ�2� Y(��=�*R'@o߮]��Zq�N8iP�B��)i�(��n�yy��S�};�f�zf�Xrmٱ��T��i�9�q�{�j�		����J`��C�(��ܦ��2�}[�s�A�B!i �"CFk�X�D�i�h�輬����2��1��"@^     