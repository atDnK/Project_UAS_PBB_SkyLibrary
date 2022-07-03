package com.udinus.uas_13037_13038_13048_13065;

import java.util.ArrayList;

public class DataBuku {
    private static String [] bookName = {
            "Judul Buku : Selamat Tinggal",
            "Judul Buku : Melangkah",
            "Judul Buku : Insecurity",
            "Judul Buku : SILAM",
            "Judul Buku : Pulang-Pergi",
            "Judul Buku : Laut Bercerita",
            "Judul Buku : HYOUKA",
            "Judul Buku : A Piece Of The Moon"
    };

    private static String [] bookDetail = {
            "Kita tidak sempurna. Kita mungkin punya keburukan, melakukan kesalahan, bahkan berbuat jahat, menyakiti orang lain. Tapi beruntunglah yang mau berubah. Berjanji tidak melakukannya lagi memperbaiki, dan menebus kesalahan tersebut. Mari tutup masa lalu yang kelam, mari membuka halaman yang baru. Jangan ragu-ragu. Jangan cemas. Tinggalkanlah kebodohan dan ketidakpedulian. “Selamat Tinggal” suka berbohong, “Selamat Tinggal” kecurangan, “Selamat Tinggal” sifat-sifat buruk lainnya. Karena sejatinya, kita tahu persis apakah kita memang benar-benar bahagia, baik, dan jujur. Sungguh “Selamat Tinggal” kepalsuan hidup.",
            "Listrik padam di seluruh Jawa dan Bali secara misterius! Ancaman nyata kekuatan baru yang hendak menaklukkan Nusantara. Saat yang sama, empat sahabat mendarat di Sumba hanya untuk mendapati nasib ratusan juta manusia ada di tangan mereka! Empat mahasiswa jurusan Ekonomi ini, harus bertarung melawan pasukan berkuda yang bisa melontarkan listrik! Semua dipersulit oleh seorang buronan tingkat tinggi bertopeng pahlawan yang punya rencana mengerikan. Ternyata pesan arwah nenek moyang itu benar – benar terwujud. “Akan datang kegelapan yang berderap, bersama ribuan kuda raksasa dikala malam. Merka bangun setelah sekian lama, untuk menghancurkan Nusantara. Seorang lelaki dan seorang perempuan ditakdirkan membaurkan air di lautan dan api di pegunungan. Menyatukan tanah yang menghujam, dan udara yang terhampar.”",
            "Penjahat dalam kisah kita bukanlah ibu tiri yang kejam, teman yang berkhianat, orang-orang yang merendahkan kita. Tapi... our own insecurity. Berjudul Insecurity is My Middle Name, karya self-healing pertama dari penulis Alvi Syahrin ini akan membawa kita untuk merenung dan berdamai atas ketidakpercayaan diri yang selama ini melekat pada masing-masing orang.",
            "Baskara hanyalah seorang anak berumur 13 tahun yang merasa tak pernah mendapatkan kasih sayang. Seumur hidup, batin dan fisiknya kerap tersiksa oleh perlakuan orang tua, dan teman-teman di sekolah. Hidup anak itu hanya seputar rumah, ibu, dan teman-teman sekolahnya yang semena-mana, tak ada kawan, tak ada saudara. Hingga suatu hari anak itu menemukan sebuah kartu nama dengan nama asing tertulis diatasnya. Nama belakang yang tertera disana sama dengan nama keluarga mendiang Ayahnya. Melalui banyak peristiwa ganjil, anak itu berhasil bertemu sang pemilik kartu nama, beralamat dilantai 4 apartemen terbengkalai, tepat dikamar nomor 4.",
            "Ada jodoh yang ditemukan lewat tatapan pertama. Ada persahabatan yang diawali lewat sapa hangat. Bagaimana jika takdir bersama ternyata diawali dengan pertarungan mematikan? Lantas semua cerita berkelindan dengan, pengejaran demi pengejaran mencari jawaban? Pulang-Pergi.",
            "Setelah hampir tiga bulan disekap dalam gelap, mereka membawaku ke sebuah tempat. Hitam. Kelam. Selama tiga bulan mataku dibebat kain apak yang hanya sesekali dibuka saat aku berurusan dengan tinja dan kencing. Aku ingat pembicaraanku dengan Sang Penyair. Dia berkata bahwa dia tak takut pada gelap. Karena dalam hidup, ada terang dan ada gelap. Ada perempuan dan ada lelaki.",
            "Oreki Hotaro adalah siswa Sekolah Menengah Atas yang berbeda dengan siswa lain yang memiliki banyak kegiatan, Oreki Hotaro adalah siswa yang hemat energi, tidak ribet dan praktis. Oreki memiliki motto hidup “ Kalau tidak perlu dikerjakan, lebih baik tidak usah dikerjakan. Tapi, kalau harus dikerjakan, lakukan dengan praktis”. Semua itu berubah, ketika dia harus bergabung  dengan klub sastra klasik, di klub tersebut dia bertemu dengan Eru Chitanda yang memiliki rasa penasaran yang tinggi. Bertemu dengan Chitanda sangat mengubah hari – hari Oreki karena dia terus berpikir untuk bisa memecahkan misteri – misteri yang terjadi di sekitarnya.",
            "“Jangan terus menanyakan mengapa kau mencintaimu. Perasaan ini disebut cinta karena aku tak tahu jawaban atas pertanyaan itu. Kau selalu berusaha untuk mengeluarkan dan menyentuh hatiku, kan? Cinta begitu melelahkan. Aku pun merasa kesakitan.” Buku ini adalah catatan harian milik Ha Hyun tentang cinta, kepolosan, dan berbagai perasaan yang kamu pasti juga pernah merasakannya. Dia memberanikan diri untuk bercerita tentang kekecewaaan, proses menjadi dewasa, dan apa arti kebahagiaan."
    };

    private static int [] bookImage = {
            R.drawable.pict2,
            R.drawable.pict3,
            R.drawable.pict1,
            R.drawable.pict4,
            R.drawable.pict5,
            R.drawable.pict6,
            R.drawable.pict7,
            R.drawable.pict8
    };

    static ArrayList<ListBook> getListData(){
        ArrayList<ListBook> list = new ArrayList<>();
        for (int position = 0; position < bookName.length; position++){
            ListBook listBook = new ListBook();
            listBook.setJudul(bookName[position]);
            listBook.setDetail(bookDetail[position]);
            listBook.setPhoto(bookImage[position]);
            list.add(listBook);
        }
        return list;
    }
}
