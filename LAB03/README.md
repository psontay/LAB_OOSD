# Ghi chú làm bài 3 - Quản lý khách sạn

Đây là ghi chú của mình trong lúc làm bài, để sau này mở lại còn nhớ mình đã làm gì.
Không phải tài liệu chuẩn, chủ yếu ghi cho dễ nhớ.

## Mình đã làm theo thứ tự nào

1. Đọc đề, xem cái ERD trong file đề trước. Đọc chữ trước rồi mới soi hình, vì có mấy bảng
   trong hình mà phần mô tả không nhắc tới.
2. Liệt kê ra giấy các bảng cần có, so lại với đề xem thiếu cái gì.
3. Viết script Oracle, chạy thử, sai đâu sửa đó.
4. Làm app WinForms sau cùng, vì phải có bảng rồi mới biết form cần những ô nào.

## Mấy chỗ đề không nói rõ, mình tự quyết

- Đề có đơn giá phòng nhưng không nói nếu khách sạn đổi giá thì hóa đơn cũ tính sao.
  Mình thêm cột DonGiaApDung vào ChiTietDatPhong, lúc lập phiếu đặt là chốt giá luôn.
  Sau này đổi giá phòng thì phiếu cũ vẫn giữ giá cũ, không bị lệch.
- Đề chỉ có "hóa đơn" chứ không nói trả nhiều lần. Nhưng thực tế khách hay đưa trước một
  phần rồi trả nốt, nên mình tách bảng ThanhToan riêng. Một hóa đơn nhiều dòng thanh toán,
  cộng lại không được vượt tổng tiền.
- Khách không đến nhận phòng thì đề không nói xử lý kiểu gì. Mình để nhân viên tự bấm
  "No-show", chứ không làm tự động theo giờ, vì đề không cho mốc thời gian nào cả.

## Những bảng mình thấy dư

Có mấy thứ mình nghĩ ra thêm mà đề không yêu cầu: tài khoản đăng nhập, lịch sử giá phòng,
giao dịch đặt cọc, phiếu kiểm tra tiện nghi định kỳ. Mình không nhét chung vào script chính
mà để riêng ra file QuanLyKhachSan_MoRong.sql, chạy sau cũng được, không chạy cũng không sao.
Để dành sau này rảnh thì làm tiếp thành module.

## Lỗi gặp phải lúc chạy script

- ORA-01408: lúc đầu mình tạo index cho (SoPhieuDat, SoPhong) rồi lại tạo thêm unique
  cho đúng mấy cột đó. Bỏ cái index thừa đi là xong.
- Tiếng Việt ra dấu hỏi hết. Phải set NLS_LANG=AMERICAN_AMERICA.AL32UTF8 trước khi chạy sqlplus.
- Chuỗi rỗng trong Oracle nó tính là NULL, nên mấy cái CHECK kiểu LENGTH(TRIM(x)) = 0 không
  bao giờ đúng. Đổi hết sang TRIM(x) IS NULL.

## Lỗi bên app

- Oracle trả tên cột viết hoa hết (SOPHONG), bind vào DataGridView thì tên cột xấu và code
  gõ sai chính tả là toi. Mình viết hàm đổi lại theo cách viết trong câu SQL.
- Combo "Kênh đặt" lúc đầu mình để 4 giá trị, trong đó có "Đại lý", chạy lên là dính lỗi
  ràng buộc CK_PhieuDat_Kenh vì trong CSDL chỉ cho 3 giá trị. Bỏ bớt cho khớp.
- Chọn dòng trên lưới rồi đọc CurrentRow thì có lúc lấy nhầm dòng cũ. Đổi sang đọc
  SelectedRows thì ổn.

## Cách chạy lại

Tạo user KHACHSAN trước, rồi:

    set NLS_LANG=AMERICAN_AMERICA.AL32UTF8
    sqlplus KHACHSAN/matkhau@localhost:1521/ORCL @QuanLyKhachSan.sql
    sqlplus KHACHSAN/matkhau@localhost:1521/ORCL @QuanLyKhachSan_MoRong.sql

Rồi copy App.config.example thành App.config, điền mật khẩu vào, mở solution bấm F5.
Mật khẩu để trong App.config chứ đừng ghi vào code, mình đã bỏ nó ra khỏi Db.cs rồi.

## Còn thiếu

Chưa làm phần đăng nhập phân quyền (bảng có rồi nhưng form thì chưa). Thống kê mới xuất CSV
chứ chưa xuất Excel thật. Phần sửa/xóa danh mục cũng chưa có, mới có thêm và xem thôi.
