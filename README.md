# LAB


---

## Thông tin sinh viên

* **Họ và tên:** Phạm Sơn Tây
* **MSSV:** 1250080169
* **Lớp:** 12_ĐH_CNPM2
* **Môn học:** Phương pháp phát triển phần mềm hướng đối tượng
* **Giảng viên:** ThS. Phạm Trọng Huynh

---

## Công nghệ & Công cụ sử dụng

* **Lập trình:** C# WinForms (.NET Framework 4.7.2)
* **Cơ sở dữ liệu:** SQL Server
* **Kiến trúc:** 3 lớp (UI → Service / Adapter → Data → SQL Server)
* **Vẽ mô hình:** PlantUML (Use Case, Biểu đồ lớp phân tích của hệ thống, Biểu đồ trạng thái, Biểu đồ lớp thiết kế chi tiết của hệ thống, Sequence, Activity, ERD, ...)
* **Công cụ:** Visual Studio, Oracle, Draw.io, Git/GitHub

---

## Danh sách các bài tập (Folder LAB)

| Bài | Tên đề tài / Chủ đề | Nội dung đã thực hiện |
| :---: | :--- | :--- |
| **LAB 0** | Cài đặt & Kiểm tra môi trường | Cài đặt JDK 21, Maven 3.9, Git; cấu hình `JAVA_HOME` & `MAVEN_HOME`; cài plugin PlantUML trên IntelliJ IDEA; chạy starter project OOP (Điểm, Tam giác, Ellipse); đóng gói file `.jar` bằng Maven CLI và thực hiện commit Git đầu tiên. |
| **LAB 1** | Viết Đặc tả Yêu cầu Use Case | Khảo sát nghiệp vụ và lập bản đặc tả yêu cầu chi tiết cho 2 bài toán: **Bài 1 - Thư viện trực tuyến** (mượn/trả sách, mua tài liệu điện tử) và **Bài 2 - Cửa hàng Nước giải khát** (đơn đặt hàng, bán hàng, phiếu hẹn & phiếu nợ). |
| **LAB 2** | Hệ thống Quản lý Thư viện | Phân tích bài toán Quản lý thư viện: vẽ bộ sơ đồ Use Case, thiết kế cơ sở dữ liệu SQL Server, phác thảo giao diện WinForms (Độc giả, Thẻ thư viện, Mượn/Trả sách, Đầu sách, Thống kê) và hiện thực code C#. |
| **LAB 3** | Hệ thống Quản lý Khách sạn | Khảo sát nghiệp vụ lưu trú, tra cứu, tính toán; vẽ Use Case, Sequence Diagram, Class Diagram; thiết kế CSDL và giao diện WinForms cho các chức năng: Đặt/Nhận phòng, Tiện nghi, Sử dụng dịch vụ, Trả phòng & Thanh toán. |
| **LAB 4** | Hệ thống e-SHOPPING | Phân tích hệ thống bán hàng online kết nối các dịch vụ bên ngoài (Quản lý sản phẩm, Thanh toán trực tuyến, Email notification); xây dựng bộ mô hình UML (Use Case, Sequence, Class) và làm prototype WinForms. |
| **LAB 5** | Quản lý Du lịch Văn Hóa Việt | Phân tích nghiệp vụ công ty du lịch: quản lý tour, hành trình, đăng ký khách lẻ/khách đoàn, phân công hướng dẫn viên, tính lương và làm khảo sát đánh giá. |
| **LAB 6** | Quản lý Hồ sơ Bệnh án | Phân tích quy trình tiếp nhận bệnh nhân, lệ phí năm, hồ sơ bệnh án, lịch khám định kỳ, xét nghiệm, lập toa thuốc và thanh toán viện phí; thiết kế CSDL có ràng buộc khóa chính/ngoại, transaction và lập kịch bản kiểm thử. |
| **LAB 7** | Quản lý Nhân sự Sơn Đông Á | Phân tích nghiệp vụ tuyển dụng, hợp đồng lao động, BHYT/BHXH, quyết định lương/chức vụ, chấm công, tăng ca/phụ trội, khen thưởng - kỷ luật và tính lương tháng; lập ma trận truy vết yêu cầu và kịch bản test case. |
| **LAB 8** | Quản lý Cửa hàng Nước Giải Khát | Phân tích toàn diện nghiệp vụ mua bán nước giải khát: nhà cung ứng, đơn đặt hàng (tối đa 3 đợt giao), bán hàng kiểm tra tồn kho khóa dòng (`UPDLOCK`), tự động lập phiếu hẹn giao nhiều đợt và phiếu ghi nợ cho Khách quen; hiện thực chuẩn kiến trúc 3 lớp WinForms C#. |

---

## Cấu trúc lưu trữ Repository

```text
LAB_OOSD/
├── LAB0/         # Báo cáo cài đặt môi trường Java, Maven, Git, IntelliJ & file starter project
├── LAB1/         # File đặc tả yêu cầu Use Case (Thư viện trực tuyến & Cửa hàng Nước giải khát)
├── LAB2/         # Bài tập Hệ thống Quản lý Thư viện (Báo cáo, UML, CSDL, WinForms)
├── LAB3/         # Bài tập Hệ thống Quản lý Khách sạn (Báo cáo, UML, CSDL, WinForms)
├── LAB4/         # Bài tập Hệ thống e-SHOPPING (Mô hình UML + Prototype)
├── LAB5/         # Bài tập Quản lý Du lịch Văn Hóa Việt
├── LAB6/         # Bài tập Quản lý Hồ sơ Bệnh án & Khám chữa bệnh
├── LAB7/         # Bài tập Quản lý Nhân sự Công ty Sơn Đông Á
└── LAB8/         # Bài tập Quản lý Cửa hàng Nước Giải Khát (Báo cáo Word, Script SQL, Source C# WinForms, README)

