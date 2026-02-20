<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;   /* horizontal center */
            align-items: center;       /* vertical center */
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            background: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
            width: 320px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 6px;
            margin-top: 5px;
        }

        input[type="submit"] {
            width: 100%;
            margin-top: 15px;
            padding: 8px;
            font-size: 15px;
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Add Student</h2>

    <form action="student" method="post">
        <label>Name</label><br>
        <input type="text" name="name"><br><br>

        <label>Branch</label><br>
        <input type="text" name="branch"><br><br>

        <label>Email</label><br>
        <input type="text" name="email"><br><br>

        <input type="submit" value="Save Student">
    </form>
</div>

</body>
</html>
