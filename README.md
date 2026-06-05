# Lost & Found Management System

A comprehensive full-stack web application for managing lost and found items. This system allows users to report lost items, browse found items, and administrators to manage the platform efficiently.

## 🎯 Features

- **User Authentication**: Secure login and registration system
- **Item Management**: Users can post lost/found items with descriptions and images
- **Admin Dashboard**: Comprehensive dashboard for managing items, users, and reports
- **Image Upload**: Support for uploading item photos to help with identification
- **Search & Filter**: Advanced search and filtering capabilities
- **Responsive UI**: Mobile-friendly design with Bootstrap
- **REST-like API**: Efficient communication between frontend and backend

## 🛠️ Technology Stack

### Backend
- **Language**: Java
- **Framework**: JSP (JavaServer Pages) & Servlets
- **Architecture**: MVC (Model-View-Controller)

### Frontend
- **HTML5**: Semantic markup
- **CSS3**: Custom styling
- **Bootstrap 4/5**: Responsive framework
- **JavaScript**: Client-side interactivity

### Database
- **MySQL**: Relational database management

## 📁 Project Structure

```
Lost-and-Found-Management-System/
├── WebContent/
│   ├── css/
│   │   └── style.css
│   ├── js/
│   │   └── script.js
│   ├── images/
│   └── views/
│       ├── index.jsp
│       ├── login.jsp
│       ├── register.jsp
│       ├── dashboard.jsp
│       ├── post-item.jsp
│       └── admin/
│           └── dashboard.jsp
├── src/
│   └── com/
│       └── lostfound/
│           ├── servlets/
│           │   ├── LoginServlet.java
│           │   ├── RegisterServlet.java
│           │   ├── ItemServlet.java
│           │   └── UploadServlet.java
│           ├── models/
│           │   ├── User.java
│           │   ├── Item.java
│           │   └── Admin.java
│           ├── dao/
│           │   ├── UserDAO.java
│           │   ├── ItemDAO.java
│           │   └── DBConnection.java
│           └── utils/
│               ├── ValidationUtil.java
│               ├── FileUploadUtil.java
│               └── Constants.java
├── WebContent/META-INF/
│   └── MANIFEST.MF
├── WebContent/WEB-INF/
│   ├── web.xml
│   └── lib/
│       ├── mysql-connector-java-8.0.x.jar
│       └── commons-fileupload-1.x.jar
├── .gitignore
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9.0 or higher
- MySQL Server 5.7 or higher
- Eclipse IDE or IntelliJ IDEA (recommended)

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/SwaroopMR/Lost-and-Found-Management-System.git
   cd Lost-and-Found-Management-System
   ```

2. **Database Setup**
   - Create a new MySQL database:
   ```sql
   CREATE DATABASE lost_found_db;
   USE lost_found_db;
   ```
   - Import the database schema:
   ```bash
   mysql -u root -p lost_found_db < database/schema.sql
   ```

3. **Configure Database Connection**
   - Open `src/com/lostfound/dao/DBConnection.java`
   - Update database credentials:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/lost_found_db";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";
   ```

4. **Deploy to Tomcat**
   - Copy the project to Tomcat `webapps` folder
   - Or deploy using Eclipse/IntelliJ IDE

5. **Access the Application**
   - Open browser and navigate to: `http://localhost:8080/Lost-and-Found-Management-System/`

## 📊 Database Schema

### Users Table
```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    phone VARCHAR(15),
    role ENUM('user', 'admin') DEFAULT 'user',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### Items Table
```sql
CREATE TABLE items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    item_type ENUM('lost', 'found') NOT NULL,
    description TEXT,
    location VARCHAR(255),
    report_date DATE NOT NULL,
    image_path VARCHAR(255),
    status ENUM('open', 'claimed', 'resolved') DEFAULT 'open',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
```

## 🔐 Authentication Flow

1. User registers with email and password
2. Password is hashed and stored securely
3. User logs in with credentials
4. Session is created and maintained
5. Admin role grants access to dashboard

## 📤 Image Upload

- Supported formats: JPG, PNG, GIF
- Maximum file size: 5MB
- Images stored in `WebContent/images/uploads/` folder
- Secure file validation implemented

## 🎨 UI Features

- **Responsive Design**: Works seamlessly on mobile, tablet, and desktop
- **Bootstrap Integration**: Modern and professional appearance
- **User-friendly Navigation**: Intuitive menu structure
- **Form Validation**: Client and server-side validation
- **Real-time Feedback**: Toast notifications and alerts

## 📝 Usage Examples

### Register a New User
1. Click on "Register" link
2. Fill in the registration form
3. Submit to create account

### Post a Lost Item
1. Login to your account
2. Click "Report Lost Item"
3. Fill in item details and upload image
4. Submit the report

### Browse Found Items
1. Navigate to "Browse Items"
2. Filter by item type or location
3. View item details and contact information

### Admin Management
1. Login with admin credentials
2. Access admin dashboard
3. Manage items, users, and reports
4. Generate reports and statistics

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📋 Future Enhancements

- [ ] Email notifications for item matches
- [ ] Advanced search with ML-based similarity matching
- [ ] Social media integration
- [ ] Mobile app (Android/iOS)
- [ ] Payment integration for premium features
- [ ] Real-time notifications using WebSockets
- [ ] Map-based location tracking
- [ ] User ratings and reviews

## 🐛 Known Issues

- None currently documented

## 📞 Support & Contact

For issues, questions, or suggestions:
- Create an issue on GitHub
- Contact: SwaroopMR

## 📄 License

This project is open source and available under the MIT License.

## 🙏 Acknowledgments

- Bootstrap team for the responsive framework
- MySQL community for database support
- Apache Tomcat team for the servlet container

---

**Last Updated**: June 2026
**Version**: 1.0.0
