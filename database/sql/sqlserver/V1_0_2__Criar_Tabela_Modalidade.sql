CREATE TABLE [sevenfit].[modalidade](
    id VARCHAR(30) UNIQUE NOT NULL,
    nome VARCHAR(150) NOT NULL,
    valor DECIMAL(15,2) NOT NULL,
    CONSTRAINT PK_ModalidadeId PRIMARY KEY(id)
)