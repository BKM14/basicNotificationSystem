# Basic Notification System

This Java application monitors the states of Caps Lock, Num Lock, and Scroll Lock keys in real-time. It provides visual updates and plays an audio notification when the state of any of these keys changes. The application features a user-friendly interface with controls to start and stop monitoring.

## Features

- **Real-Time Monitoring**: Tracks the states of Caps Lock, Num Lock, and Scroll Lock keys.
- **Visual Alerts**: Displays current key states in a table and updates them in real-time.
- **Audio Notifications**: Plays a sound when a key state changes.
- **User-Friendly Interface**: Easy-to-use buttons to start and stop the monitoring process.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An audio file named `tune.wav` in the same directory as the application

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/BKM14/basicNotificationSystem.git
    ```
2. Navigate to the project directory:
    ```sh
    cd BasicNotificationSystem
    ```
3. Ensure the `tune.wav` file is in the project directory.

### Running the Application

1. Compile the code:
    ```sh
    javac Main.java
    ```
2. Run the application:
    ```sh
    java Main
    ```

## Usage

1. **Start Monitoring**: Click the "Start listening" button to begin monitoring key events. The status will update to "Listening to key events...".
2. **Stop Monitoring**: Click the "Stop listening" button to stop monitoring key events. The status will update to "Stopped listening to key events.".
3. **Key State Updates**: The table will show the current states of Caps Lock, Num Lock, and Scroll Lock. When these keys are pressed or released, the table and a label will update to reflect the new states, and a sound will play.

## Code Overview

- **Main Class**: Sets up the user interface and manages key event monitoring.
- **updateKeyStates Method**: Updates the key states in the table and label.
- **getLockingKeyState Method**: Retrieves the state of a specific key.
- **playNotificationSound Method**: Plays the notification sound when a key state changes.

## Future Enhancements

1. **Customizable Notifications**: Allow users to customize sounds and visual alerts.
2. **Cross-Platform Compatibility**: Improve consistency across different operating systems.
3. **Extended Key Monitoring**: Monitor additional keys like function keys and modifier keys.
4. **Accessibility Features**: Introduce alternative notifications for users with impairments.


Thank you for using the Basic Notification System!
