
/*==============================================================*/
/* Table: INF_CATALOGO                                          */
/*==============================================================*/
create table INF_CATALOGO (
   CAT_CODIGO           VARCHAR(4)           not null,
   CAT_NOMBRE           VARCHAR(20)          null,
   CAT_DESCRIPCION      TEXT                 null,
   constraint PK_INF_CATALOGO primary key (CAT_CODIGO)
);

/*==============================================================*/
/* Table: INF_CATEGORIA                                         */
/*==============================================================*/
create table INF_CATEGORIA (
   CAT_CODIGO           VARCHAR(5)           not null,
   CAT_TITULO           VARCHAR(50)          null,
   CAT_ICON             VARCHAR(4)           null,
   CAT_DESCRIPCION      TEXT                 null,
   constraint PK_INF_CATEGORIA primary key (CAT_CODIGO)
);

/*==============================================================*/
/* Table: INF_IMAGEN                                            */
/*==============================================================*/
create table INF_IMAGEN (
   IMA_CODIGO           VARCHAR(150)         not null,
   INF_CODIGO_GEN       VARCHAR(5)           null,
   INF_CODIGO           VARCHAR(5)           null,
   IMA_NOMBRE           TEXT                 null,
   IMA_DIRECCION        TEXT                 null,
   constraint PK_INF_IMAGEN primary key (IMA_CODIGO)
);

/*==============================================================*/
/* Table: INF_INFORMACION                                       */
/*==============================================================*/
create table INF_INFORMACION (
   INF_CODIGO           VARCHAR(5)           not null,
   CAT_CODIGO           VARCHAR(5)           null,
   INF_FECHA            DATE                 null,
   INF_TITULO           VARCHAR(150)         null,
   INF_DESCRIPCION      TEXT                 null,
   INF_LATITUD          TEXT                 null,
   INF_LONGITUD         TEXT                 null,
   INF_URL              TEXT                 null,
   constraint PK_INF_INFORMACION primary key (INF_CODIGO)
);

/*==============================================================*/
/* Table: INF_INFORMACION_GENERAL                               */
/*==============================================================*/
create table INF_INFORMACION_GENERAL (
   INF_CODIGO_GEN       VARCHAR(5)           not null,
   INF_TITULO           VARCHAR(150)         null,
   INF_DESCRIPCION      TEXT                 null,
   INF_ICONO            VARCHAR(4)           null,
   INF_ESTADO           VARCHAR(4)           null,
   constraint PK_INF_INFORMACION_GENERAL primary key (INF_CODIGO_GEN)
);

/*==============================================================*/
/* Table: INF_ITEM                                              */
/*==============================================================*/
create table INF_ITEM (
   ITE_CODIGO           VARCHAR(4)           not null,
   CAT_CODIGO           VARCHAR(4)           null,
   ITE_NOMBRE           VARCHAR(200)         null,
   ITE_PADRE            VARCHAR(4)           null,
   constraint PK_INF_ITEM primary key (ITE_CODIGO)
);

/*==============================================================*/
/* Table: INF_USUARIO                                           */
/*==============================================================*/
create table INF_USUARIO (
   USU_LOGIN            VARCHAR(30)          not null,
   USU_NOMBRE           VARCHAR(300)         null,
   USU_CONTACTO         VARCHAR(150)         null,
   USU_CONTRASENA       VARCHAR(20)          null,
   USU_TIPO             VARCHAR(4)           null,
   USU_ESTADO           VARCHAR(4)           null,
   constraint PK_INF_USUARIO primary key (USU_LOGIN)
);

alter table INF_IMAGEN
   add constraint FK_INF_IMAG_REFERENCE_INF_INFO_GEN foreign key (INF_CODIGO_GEN)
      references INF_INFORMACION_GENERAL (INF_CODIGO_GEN)
      on delete restrict on update restrict;

alter table INF_IMAGEN
   add constraint FK_INF_IMAG_REFERENCE_INF_INFO foreign key (INF_CODIGO)
      references INF_INFORMACION (INF_CODIGO)
      on delete restrict on update restrict;

alter table INF_INFORMACION
   add constraint FK_INF_INFO_REFERENCE_INF_CATE foreign key (CAT_CODIGO)
      references INF_CATEGORIA (CAT_CODIGO)
      on delete restrict on update restrict;

alter table INF_ITEM
   add constraint FK_INF_ITEM_REFERENCE_INF_CATA foreign key (CAT_CODIGO)
      references INF_CATALOGO (CAT_CODIGO)
      on delete restrict on update restrict;