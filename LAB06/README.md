# LAB 06 - Quản lý hồ sơ bệnh án

Sinh viên: Phạm Sơn Tây – MSSV: 1250080169.

## Cấu trúc thư mục

* `BaoCao_LAB06_QuanLyBenhAn.docx`: Báo cáo chi tiết (đặc tả use case, state diagram, class diagram, ERD, ràng buộc, thiết kế giao diện, bảng kiểm tra).
* `QuanLyBenhAn.sql`: Script Oracle 19c (16 bảng, 12 sequence, trigger, dữ liệu mẫu).
* `QuanLyBenhAn/`: Source code Visual Studio 2022 (WinForms .NET Framework 4.7.2, ODP.NET Managed).
* `plantuml/`: Source `.puml` và ảnh render của các sơ đồ UML.
* `screenshots/`: Ảnh chụp giao diện chức năng và lịch sử khám.
* `ketqua_kiemthu.txt`: Log chạy tự động 18 test case nghiệp vụ.

## Yêu cầu môi trường

* Oracle Database 19c
* SQL*Plus
* Visual Studio 2022
* .NET Framework 4.7.2 Developer Pack

## Hướng dẫn cài đặt

1. Tạo schema Oracle (dùng tài khoản có quyền DBA). Không chạy trên schema đang có dữ liệu thực tế.

```sql
CREATE USER BENHAN IDENTIFIED BY matkhau DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
GRANT CREATE SESSION, CREATE TABLE, CREATE SEQUENCE, CREATE TRIGGER TO BENHAN;

```

2. Nạp CSDL và dữ liệu mẫu qua cmd:

```bat
set NLS_LANG=AMERICAN_AMERICA.AL32UTF8
sqlplus BENHAN/matkhau@localhost:1521/ORCL @QuanLyBenhAn.sql

```

3. Mở `QuanLyBenhAn/QuanLyBenhAn.sln` bằng Visual Studio.
4. Mở `App.config`, sửa `YOUR_PASSWORD` và `Data Source` tương ứng với database của bạn.
5. Build và chạy (F5). Thư viện `Oracle.ManagedDataAccess.dll` đã được đính kèm trong thư mục `lib/`.

## Luồng chức năng chính

Sử dụng các mã mẫu để test: Hồ sơ `HS0001`, Bác sĩ `BS01`, Xét nghiệm `XN01`, Thuốc `T01`.

* **Tra cứu hồ sơ:** Xem thông tin bệnh nhân và lịch sử (lượt khám, toa thuốc, xét nghiệm, phản ứng thuốc).
* **Đăng ký & Cấp hồ sơ:** Nhập thông tin, thu lệ phí, tạo phiếu và cấp mã trong 1 transaction. Có chức năng gia hạn lệ phí cho bệnh nhân cũ.
* **Đặt lịch hẹn:** Chọn bác sĩ. Tự động kiểm tra lệ phí năm và chặn nếu vượt giới hạn lịch khám định kỳ (1 lần/quý).
* **Khám bệnh:** Tạo lượt khám, nhập triệu chứng, chẩn đoán.
* **Xét nghiệm:** Tạo chỉ định và nhập kết quả.
* **Lập toa thuốc:** Kê toa, chọn thuốc và liều dùng. Ràng buộc: Không cho phép kê toa nếu có xét nghiệm chưa trả kết quả.
* **Thanh toán & Xuất viện:** Nhập kết luận và viện phí. Viện phí khám định kỳ bắt buộc bằng 0.
* **Phản ứng thuốc:** Ghi nhận dị ứng để lưu vào lịch sử theo dõi.

## Kiến trúc & Giới hạn

* `MainForm.cs`: Quản lý UI/UX.
* `ClinicService.cs`: Chứa logic nghiệp vụ và quản lý transaction.
* `Db.cs`: Xử lý kết nối Oracle và SQL tham số.

Giới hạn phiên bản hiện tại:

* Chưa có tính năng đăng nhập/phân quyền.
* Giao diện UI hiện tại chỉ hỗ trợ nhập 1 loại thuốc/toa trong một lần lưu.
* Ảnh bệnh nhân đang lưu dạng đường dẫn nội bộ.
* Thiếu form quản trị CRUD cho các danh mục (Khoa, Bác sĩ, Thuốc, Xét nghiệm).

## Kiểm thử

Hệ thống đã pass 18/18 test case trên schema `L06VERIFY` (Oracle 19c).

Để tự chạy bộ test tự động:

1. Đặt biến môi trường `LAB06_CONNECTION` là chuỗi kết nối Oracle.
2. Chạy file thực thi với tham số: `QuanLyBenhAn.exe /kiemthu ketqua.txt`
3. Tool chụp ảnh tự động: `QuanLyBenhAn.exe /chupanhdb <thư_mục_lưu>`

Lưu ý: Quá trình test sẽ tạo ra dữ liệu rác, chỉ chạy trên schema dành riêng cho việc kiểm thử. Không push mật khẩu thật lên source control.
