CREATE DATABASE account_login
USE account_login
CREATE TABLE account (
	[username] [nvarchar](255) NULL,
	[password] [nvarchar](255) NULL,
	[displayName] [nvarchar](255) NULL,
);
GO

INSERT INTO account([username], [password], [displayName]) VALUES (N'admin', N'admin', N'administrator');
INSERT INTO account([username], [password], [displayName]) VALUES (N'hello', N'hello', N'hello');
INSERT INTO account([username], [password], [displayName]) VALUES (N'hoang', N'12345', N'hoang');
INSERT INTO account([username], [password], [displayName]) VALUES (N'abc', N'12345', N'abcUser');
INSERT INTO account([username], [password], [displayName]) VALUES (N'club', N'11111', N'club');
INSERT INTO account([username], [password], [displayName]) VALUES (N'user', N'00000', N'user');
INSERT INTO account([username], [password], [displayName]) VALUES (N'chinh', N'haha123', N'chinhchinh');
INSERT INTO account([username], [password], [displayName]) VALUES (N'hoahong', N'hoahong', N'bonghoahong');

GO