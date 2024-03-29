<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Chat</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/normalize.css"/>
    <link rel="stylesheet" href="../styles/app.css"/>
</head>
<body>
<header>
    <h1>WebSocket Chat Demo</h1>
</header>
<section id="messageContainer">
    <form id="messageForm">
        <fieldset>
            <legend>Chat with others</legend>
            <p>
                <label for="userName">Your name:</label><br>
                <input type="text" name="userName" id="userName">
            </p>
            <p>
                <label for="message">Message:</label><br>
                <input type="text" name="message" id="message" maxlength="280">
            </p>
            <input type="submit" value="Send">
            <span id="errorText" style="color:red;"></span>
        </fieldset>
    </form>
    <div id="messages"></div>
</section>
<script src="../scripts/websocket.js"></script>
</body>
</html>
