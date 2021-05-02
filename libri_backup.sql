PGDMP     &    &                y            Libri    13.0    13.0 ,    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16881    Libri    DATABASE     g   CREATE DATABASE "Libri" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Libri";
                postgres    false            �            1259    16910    cargo    TABLE     �   CREATE TABLE public.cargo (
    ide integer NOT NULL,
    nome character varying(100) NOT NULL,
    salario numeric(7,2) NOT NULL
);
    DROP TABLE public.cargo;
       public         heap    postgres    false            �            1259    16908    cargo_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cargo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.cargo_id_seq;
       public          postgres    false    203            �           0    0    cargo_id_seq    SEQUENCE OWNED BY     >   ALTER SEQUENCE public.cargo_id_seq OWNED BY public.cargo.ide;
          public          postgres    false    202            �            1259    16918    funcionario    TABLE     �   CREATE TABLE public.funcionario (
    ide integer NOT NULL,
    id_pessoa integer,
    id_cargo integer,
    login character varying(25),
    senha character varying(25)
);
    DROP TABLE public.funcionario;
       public         heap    postgres    false            �            1259    16916    funcionario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.funcionario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.funcionario_id_seq;
       public          postgres    false    205            �           0    0    funcionario_id_seq    SEQUENCE OWNED BY     J   ALTER SEQUENCE public.funcionario_id_seq OWNED BY public.funcionario.ide;
          public          postgres    false    204            �            1259    16936    livro    TABLE     �  CREATE TABLE public.livro (
    ide integer NOT NULL,
    isbn10 character varying(10) NOT NULL,
    isbn13 character varying(13) NOT NULL,
    paginas integer NOT NULL,
    editora character varying(100) NOT NULL,
    estoque integer NOT NULL,
    val_compra numeric(5,2) NOT NULL,
    val_venda numeric(5,2) NOT NULL,
    idioma character varying(20) NOT NULL,
    data_publicacao date NOT NULL,
    titulo character varying(100),
    autor character varying(100)
);
    DROP TABLE public.livro;
       public         heap    postgres    false            �            1259    16934    livro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.livro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.livro_id_seq;
       public          postgres    false    207            �           0    0    livro_id_seq    SEQUENCE OWNED BY     >   ALTER SEQUENCE public.livro_id_seq OWNED BY public.livro.ide;
          public          postgres    false    206            �            1259    16944    pedido    TABLE     c  CREATE TABLE public.pedido (
    ide integer NOT NULL,
    id_pedido integer NOT NULL,
    operacao character varying(5) NOT NULL,
    id_livro integer,
    quantidade integer NOT NULL,
    valor numeric(5,2) NOT NULL,
    id_funcionario integer,
    data_pedido date NOT NULL,
    hora time without time zone NOT NULL,
    lucro numeric(7,2) NOT NULL
);
    DROP TABLE public.pedido;
       public         heap    postgres    false            �            1259    16942    pedido_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pedido_id_seq;
       public          postgres    false    209            �           0    0    pedido_id_seq    SEQUENCE OWNED BY     @   ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedido.ide;
          public          postgres    false    208            �            1259    16900    pessoa    TABLE     ,  CREATE TABLE public.pessoa (
    ide integer NOT NULL,
    nome character varying(100) NOT NULL,
    nascimento date NOT NULL,
    genero character varying(1) NOT NULL,
    cpf character varying(14) NOT NULL,
    idade integer,
    endereco character varying(150),
    email character varying(50)
);
    DROP TABLE public.pessoa;
       public         heap    postgres    false            �            1259    16898    pessoa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pessoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pessoa_id_seq;
       public          postgres    false    201            �           0    0    pessoa_id_seq    SEQUENCE OWNED BY     @   ALTER SEQUENCE public.pessoa_id_seq OWNED BY public.pessoa.ide;
          public          postgres    false    200            ;           2604    16913 	   cargo ide    DEFAULT     e   ALTER TABLE ONLY public.cargo ALTER COLUMN ide SET DEFAULT nextval('public.cargo_id_seq'::regclass);
 8   ALTER TABLE public.cargo ALTER COLUMN ide DROP DEFAULT;
       public          postgres    false    202    203    203            <           2604    16921    funcionario ide    DEFAULT     q   ALTER TABLE ONLY public.funcionario ALTER COLUMN ide SET DEFAULT nextval('public.funcionario_id_seq'::regclass);
 >   ALTER TABLE public.funcionario ALTER COLUMN ide DROP DEFAULT;
       public          postgres    false    205    204    205            =           2604    16939 	   livro ide    DEFAULT     e   ALTER TABLE ONLY public.livro ALTER COLUMN ide SET DEFAULT nextval('public.livro_id_seq'::regclass);
 8   ALTER TABLE public.livro ALTER COLUMN ide DROP DEFAULT;
       public          postgres    false    207    206    207            >           2604    16947 
   pedido ide    DEFAULT     g   ALTER TABLE ONLY public.pedido ALTER COLUMN ide SET DEFAULT nextval('public.pedido_id_seq'::regclass);
 9   ALTER TABLE public.pedido ALTER COLUMN ide DROP DEFAULT;
       public          postgres    false    209    208    209            :           2604    16903 
   pessoa ide    DEFAULT     g   ALTER TABLE ONLY public.pessoa ALTER COLUMN ide SET DEFAULT nextval('public.pessoa_id_seq'::regclass);
 9   ALTER TABLE public.pessoa ALTER COLUMN ide DROP DEFAULT;
       public          postgres    false    201    200    201            �          0    16910    cargo 
   TABLE DATA           3   COPY public.cargo (ide, nome, salario) FROM stdin;
    public          postgres    false    203   D2       �          0    16918    funcionario 
   TABLE DATA           M   COPY public.funcionario (ide, id_pessoa, id_cargo, login, senha) FROM stdin;
    public          postgres    false    205   �2       �          0    16936    livro 
   TABLE DATA           �   COPY public.livro (ide, isbn10, isbn13, paginas, editora, estoque, val_compra, val_venda, idioma, data_publicacao, titulo, autor) FROM stdin;
    public          postgres    false    207   �2       �          0    16944    pedido 
   TABLE DATA           �   COPY public.pedido (ide, id_pedido, operacao, id_livro, quantidade, valor, id_funcionario, data_pedido, hora, lucro) FROM stdin;
    public          postgres    false    209   �4       �          0    16900    pessoa 
   TABLE DATA           \   COPY public.pessoa (ide, nome, nascimento, genero, cpf, idade, endereco, email) FROM stdin;
    public          postgres    false    201   45       �           0    0    cargo_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.cargo_id_seq', 4, true);
          public          postgres    false    202            �           0    0    funcionario_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.funcionario_id_seq', 6, true);
          public          postgres    false    204            �           0    0    livro_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.livro_id_seq', 7, true);
          public          postgres    false    206            �           0    0    pedido_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pedido_id_seq', 10, true);
          public          postgres    false    208            �           0    0    pessoa_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pessoa_id_seq', 13, true);
          public          postgres    false    200            D           2606    16915    cargo cargo_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (ide);
 :   ALTER TABLE ONLY public.cargo DROP CONSTRAINT cargo_pkey;
       public            postgres    false    203            F           2606    16923    funcionario funcionario_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (ide);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public            postgres    false    205            H           2606    16941    livro livro_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (ide);
 :   ALTER TABLE ONLY public.livro DROP CONSTRAINT livro_pkey;
       public            postgres    false    207            J           2606    16949    pedido pedido_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (ide);
 <   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_pkey;
       public            postgres    false    209            @           2606    16907    pessoa pessoa_cpf_key 
   CONSTRAINT     O   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_cpf_key UNIQUE (cpf);
 ?   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_cpf_key;
       public            postgres    false    201            B           2606    16905    pessoa pessoa_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (ide);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    201            L           2606    16929 %   funcionario funcionario_id_cargo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_id_cargo_fkey FOREIGN KEY (id_cargo) REFERENCES public.cargo(ide);
 O   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_id_cargo_fkey;
       public          postgres    false    2884    203    205            K           2606    16924 &   funcionario funcionario_id_pessoa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_id_pessoa_fkey FOREIGN KEY (id_pessoa) REFERENCES public.pessoa(ide);
 P   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_id_pessoa_fkey;
       public          postgres    false    2882    205    201            N           2606    16955 !   pedido pedido_id_funcionario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_id_funcionario_fkey FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(ide);
 K   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_id_funcionario_fkey;
       public          postgres    false    205    2886    209            M           2606    16950    pedido pedido_id_livro_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_id_livro_fkey FOREIGN KEY (id_livro) REFERENCES public.livro(ide);
 E   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_id_livro_fkey;
       public          postgres    false    2888    207    209            �   9   x�3�s�squ��4450�30�2�tv�p�44���9�]�\�B\9� "1z\\\ aRO      �   W   x�%�A
�0��cĤ�k�T�6PS����M��aw��<9>&?2��U��Hm�k�@���v�j�����M���U���y@��=      �   �  x�u��n�0�������ȗ��8�d1�d�	�0��V�O��Űn�A� �Gk0Mkt[K��|��V��B^_Sv=a�gh�͓RP��^9�y�׷Z��P��2pv��	���8[��)1d��`ovrEe�M�j�4���:B]i��<f8��ٻ��=�1����>�������J�D���Ϙ��0����1�d9X����w�T���(]�J=0ؕ�����q�����kI]�W���==��iN��@?�q x��B���{t� ��z�ҕ�F�8
q��ؕ��(L�	J��p��W���^n,�up�z�z�~�70>��l,�ͨ5���j7�PZ�װ�(q;�қI�ϸ۞�'��BRm�Ѣ��]�S�D'"�~q�(�m�NU�����Pum�/��}t,dw���x���5�.{ǅ��M /2�9Q�ӄ��ɯ��<E��̲w      �   d   x���=�0Fg�K��=������_jFkH�=��A�>�c֊�iv�4�ҩv�>P�@��b�(��>7����g�4s��&�ҀMi�� 1.      �   �   x�M�Qk�0���S�4�%qƼ5]��@����b7������X������BU����g��m��ID��0:�TIT������j��v�������?㷮�U�ϾI���u���7W;����d����<��Ĩ�YXV�>��۵F�2|N7����i�2.�\1K1�4汶��U�̮���Ii�k>���q��i���/�w����i���<�#UI��D��*���T��N��L��FSG     