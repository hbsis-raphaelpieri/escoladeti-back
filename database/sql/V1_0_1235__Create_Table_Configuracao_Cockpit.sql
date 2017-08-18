CREATE TABLE [cockpit].[ConfiguracaoCockpit]( 
    [Id] UNIQUEIDENTIFIER NOT NULL,
	[ArmazemId] UNIQUEIDENTIFIER NOT NULL,
    [HorarioMetaFimSeparacao] TIME NOT NULL,
    CreatedDate DATETIME,
	UpdatedDate DATETIME,
	CreatedBy VARCHAR(20),
	UpdatedBy VARCHAR(20),
	CONSTRAINT PK_ConfiguracaoCockpitId PRIMARY KEY (Id),
	CONSTRAINT FK_ConfiguracaoCockpitArmazemId FOREIGN KEY (ArmazemId) REFERENCES management.warehouse
)
GO

grant delete on  [cockpit].ConfiguracaoCockpit to [DE_WMS]
grant select on  [cockpit].ConfiguracaoCockpit to [SE_WMS]
grant update on  [cockpit].ConfiguracaoCockpit to [UP_WMS]
grant insert on  [cockpit].ConfiguracaoCockpit to [IN_WMS]
GO