# LAB 04 – Hệ thống cửa hàng online e-SHOPPING

Đề tài `Bai_9_GOC`: phân tích, thiết kế hệ thống cửa hàng ABC bán hàng online mùa Giáng Sinh, xây dựng CSDL Oracle và ứng dụng WinForms kết nối trực tiếp với CSDL.

## Cấu trúc chính

| File / thư mục | Nội dung |
|---|---|
| `BaoCao_LAB04_EShopping.docx` | Báo cáo phân tích, thiết kế, ERD, SQL, giao diện và kiểm thử |
| `EShopping.sql` | Script Oracle: bảng, sequence, function, trigger, view và dữ liệu mẫu |
| `EShopping/` | Ứng dụng WinForms (.NET Framework 4.7.2, ODP.NET Managed) |
| `plantuml/` | Mã và ảnh các sơ đồ PlantUML |
| `_build/` | Script hỗ trợ sinh sơ đồ, form, project và báo cáo |

## Cách chạy

### 1. Chuẩn bị Oracle

Bật:

- `OracleServiceORCL`
- `OracleOraDB19Home1TNSListener`

Tạo user bằng tài khoản DBA:

```sql
CREATE USER ESHOP IDENTIFIED BY <mật_khẩu>
DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE PROCEDURE,
CREATE TRIGGER, CREATE SEQUENCE TO ESHOP;
```

### 2. Tạo CSDL

```bash
set NLS_LANG=AMERICAN_AMERICA.AL32UTF8
sqlplus ESHOP/<mật_khẩu>@localhost:1521/ORCL @EShopping.sql
```

### 3. Chạy ứng dụng

1. Sao chép `EShopping/EShopping/App.config.example` thành `App.config`.
2. Điền mật khẩu user `ESHOP`.
3. Mở `EShopping/EShopping.sln` bằng Visual Studio 2022.
4. Nhấn **F5**.

`App.config` không đưa lên Git.

## Tài khoản và dữ liệu thử

Mật khẩu tài khoản mẫu: `Eshop@123`

- Khách hàng: `an.nv`, `binh.tt`
- Nhân viên: `admin`, `banhang`

Thẻ thử:

- VISA `4111 1111 1111 1111`: chấp thuận
- VISA `4000 0000 0000 0002`: từ chối
- AmEx `3782 822463 10005`

Email xác nhận được lưu tại `bin\Debug\MailPickup`.

## Kiểm thử

Chạy kiểm thử tự động:

```bash
EShopping.exe /kiemthu ketqua.txt
```

Lệnh này chạy 26 ca kiểm thử end-to-end trên CSDL và tự dọn dữ liệu thử.

Chụp ảnh giao diện:

```bash
EShopping.exe /chupanh <thư_mục>
```
