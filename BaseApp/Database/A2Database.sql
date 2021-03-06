PGDMP     $                    y        
   A2Database    13.2    13.2     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    28937 
   A2Database    DATABASE     p   CREATE DATABASE "A2Database" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1250';
    DROP DATABASE "A2Database";
                postgres    false            ?            1259    32330    address    TABLE     '  CREATE TABLE public.address (
    id character varying(255) NOT NULL,
    apartment character varying(255),
    building character varying(255),
    city character varying(255),
    floor character varying(255),
    house_hold_number character varying(255),
    street character varying(255)
);
    DROP TABLE public.address;
       public         heap    postgres    false            ?            1259    32338    festival_ticket    TABLE     ?   CREATE TABLE public.festival_ticket (
    id character varying(255) NOT NULL,
    end_date date,
    name character varying(255),
    price integer,
    start_date date,
    type character varying(255),
    user_transaction_id character varying(255)
);
 #   DROP TABLE public.festival_ticket;
       public         heap    postgres    false            ?            1259    32346    user_profile    TABLE     5  CREATE TABLE public.user_profile (
    id character varying(255) NOT NULL,
    birth_date date,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    permission boolean,
    address_id character varying(255)
);
     DROP TABLE public.user_profile;
       public         heap    postgres    false            ?            1259    32354    user_transaction    TABLE     ?   CREATE TABLE public.user_transaction (
    id character varying(255) NOT NULL,
    no_of_tickets integer,
    user_profilet_id character varying(255),
    ticket_id character varying(255)
);
 $   DROP TABLE public.user_transaction;
       public         heap    postgres    false            ?          0    32330    address 
   TABLE DATA           b   COPY public.address (id, apartment, building, city, floor, house_hold_number, street) FROM stdin;
    public          postgres    false    200   ?       ?          0    32338    festival_ticket 
   TABLE DATA           k   COPY public.festival_ticket (id, end_date, name, price, start_date, type, user_transaction_id) FROM stdin;
    public          postgres    false    201   ?       ?          0    32346    user_profile 
   TABLE DATA           v   COPY public.user_profile (id, birth_date, email, first_name, last_name, password, permission, address_id) FROM stdin;
    public          postgres    false    202   ?       ?          0    32354    user_transaction 
   TABLE DATA           Z   COPY public.user_transaction (id, no_of_tickets, user_profilet_id, ticket_id) FROM stdin;
    public          postgres    false    203   D       1           2606    32337    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            postgres    false    200            3           2606    32345 $   festival_ticket festival_ticket_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.festival_ticket
    ADD CONSTRAINT festival_ticket_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.festival_ticket DROP CONSTRAINT festival_ticket_pkey;
       public            postgres    false    201            5           2606    32353    user_profile user_profile_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.user_profile
    ADD CONSTRAINT user_profile_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.user_profile DROP CONSTRAINT user_profile_pkey;
       public            postgres    false    202            7           2606    32361 &   user_transaction user_transaction_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_transaction
    ADD CONSTRAINT user_transaction_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.user_transaction DROP CONSTRAINT user_transaction_pkey;
       public            postgres    false    203            8           2606    32362 +   festival_ticket fk2y2545uu2o7ira5dvelk7wepw    FK CONSTRAINT     ?   ALTER TABLE ONLY public.festival_ticket
    ADD CONSTRAINT fk2y2545uu2o7ira5dvelk7wepw FOREIGN KEY (user_transaction_id) REFERENCES public.user_transaction(id);
 U   ALTER TABLE ONLY public.festival_ticket DROP CONSTRAINT fk2y2545uu2o7ira5dvelk7wepw;
       public          postgres    false    201    2871    203            :           2606    32372 ,   user_transaction fk4nr5c9cbq59r2wwpqpqpypiu8    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_transaction
    ADD CONSTRAINT fk4nr5c9cbq59r2wwpqpqpypiu8 FOREIGN KEY (user_profilet_id) REFERENCES public.user_profile(id);
 V   ALTER TABLE ONLY public.user_transaction DROP CONSTRAINT fk4nr5c9cbq59r2wwpqpqpypiu8;
       public          postgres    false    2869    203    202            ;           2606    35583 ,   user_transaction fke2slw0wk0ogvsdyyu1qxocrhh    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_transaction
    ADD CONSTRAINT fke2slw0wk0ogvsdyyu1qxocrhh FOREIGN KEY (ticket_id) REFERENCES public.festival_ticket(id);
 V   ALTER TABLE ONLY public.user_transaction DROP CONSTRAINT fke2slw0wk0ogvsdyyu1qxocrhh;
       public          postgres    false    203    201    2867            9           2606    32367 (   user_profile fkt7ck1erxe5phbhrdk1cn92h52    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_profile
    ADD CONSTRAINT fkt7ck1erxe5phbhrdk1cn92h52 FOREIGN KEY (address_id) REFERENCES public.address(id);
 R   ALTER TABLE ONLY public.user_profile DROP CONSTRAINT fkt7ck1erxe5phbhrdk1cn92h52;
       public          postgres    false    2865    202    200            ?   ?   x????N?0?k?)? ??Y?????!??kF?NJ?OO?A???b??V;??l??<{??ؔ*D?|p>?Yk?H??V?D???{ib纳?P,?mTK?Q?MMf?e????^;???6Z?V?A=^V:7?.?????,?3?E??)i??.??v???}?ÓX???N/??o(+]??X?_.5O?
O6RJ??`?O?'v?s$??0??j?????庐??_j??ܺ|???z8      ?     x?m??N1??٧?0J???=W*Bbũ'qJUP????)??+q????2????!P?f?'?Z???G?? ??y?????????[=?h??????^:???8:?90?8(??f??A3?$???n?0#?g]K?]??$.?U?/??({?Ԯ?#y?Ɲ3???~Z.?'??lgJ?:?Q4TR?(??s?? B?$8???????n??f?̤???R??k*]?CjV?	?#?k?ۿ?b??4?Z;k}/6?????o+?z"      ?   D  x???Mn$!???)r?????ukV?f5&??F?I???Е?$YEB?̳x?3?1?,?
C4/PJ2ȁ[L??Yq??#????.?????^^wO??????oݝ?o??????ή?:k?	b?
???F?$?????1V?V??"c?P??jb?Y?`@??8m?????\????_????X(P/X?A$?/`إ????:S?AKJ???S?bF>??|?'??M???Dv??|? 6??ܔ?+?c??C?5??l		?
??P?{??
0%W?????>???6??K??jOV??H@???oOh??s??R-??k???/@?      ?   J  x????? !?ݹ0Or???0A_U(~aE?1!&???W`1GL??>?|?1`Ǆ@b?*B?????1xm?z?Ft?P?[Y?'?w?֋`?
x1??9 n??y?7`??b?0+p??%ݚ?q/????,?k@kv'?f3?????)>k?96\?޴????M?8???>Q?NWu?l??5H(Q?^<2MP?:wB&N?bQ?A??+k-/??????%a@?%N&?V?T,?:q[C??*?
?I???6?ﰰ??g?~?"???J?\;+?)??k?)p???i????HV???ׯ@Y??ٿ@o?R?^'L?c??d????}?_?7     