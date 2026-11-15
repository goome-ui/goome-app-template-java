<p align="center">
  <img src="https://raw.githubusercontent.com/goome-ui/.github/main/profile/logo.png" alt="goome" width="150">
</p>

<h1 align="center">☕ goome app template: Java ☕</h1>

<p align="center">
<b>A tiny goome app in Java to start from. A normal window, and one toggle turns it into an overlay on top of everything.</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-22%2B-6fdc5f?style=flat-square&logo=openjdk&logoColor=1b1d22&labelColor=6fdc5f" alt="Java 22+">
  <img src="https://img.shields.io/badge/template-use%20me-1b1d22?style=flat-square&labelColor=6fdc5f" alt="template">
  <img src="https://img.shields.io/badge/license-GPL--3.0-1b1d22?style=flat-square" alt="GPL-3.0">
</p>

<p align="center">
  Hit <b>Use this template</b> up top and you get your own copy that builds right away, CI included. Or let <a href="https://github.com/goome-ui/goome-cli">goome-cli</a> make it with your own name already in it.<br>
  Its <a href="https://github.com/goome-ui/java-goome">java-goome</a> underneath, the docs for the whole ui kit are at <a href="https://goome-ui.github.io/docs/">goome-ui.github.io/docs</a>.<br> <br>
  Do you like this project? If so, please let me know!
  <a href="https://sevvy-wevvy.com/discord">Discord</a>
</p>

<p align="center">
  <a href="https://goome-ui.github.io/docs/">Docs</a> &nbsp;·&nbsp;
  <a href="https://github.com/goome-ui/goome-cli">goome-cli</a> &nbsp;·&nbsp;
  <a href="https://github.com/goome-ui/java-goome">java-goome</a> &nbsp;·&nbsp;
  <a href="https://github.com/goome-ui/examples">Examples</a>
</p>

<p align="center">
  The <a href="https://goome-ui.github.io/docs/downloads/">ready made apps</a> on the <a href="https://github.com/goome-ui/examples/releases/latest">examples release</a> show what you can build from here.<br>
  If you get stuck, ask in <a href="https://github.com/goome-ui/c-goome/discussions">Discussions</a>. The <a href="https://github.com/goome-ui/java-goome/labels/good%20first%20issue">good first issues</a> on java-goome are small ones if you want to help.
</p>

<details>
<summary align="center"><b>🚀 Make Your Own 🚀</b></summary>

<br>

<p align="center">
<b>Use this template</b> on GitHub gives you this repo as it is. With goome-cli you pick the name and which template you want:
</p>

```sh
pip install git+https://github.com/goome-ui/goome-cli
goome new my-thing --lang java
goome new my-thing --lang java --template hud
```

<p align="center">
It swaps "My Goome App" and friends for your name everywhere, files too, and leaves out the template only stuff.
</p>
</details>

<details>
<summary align="center"><b>🔨 Build And Run 🔨</b></summary>

<br>

<p align="center">
You need a JDK 22 or newer, goome talks to its C library with FFM. Gradle downloads itself and gets <code>goome-x.y.z.jar</code> straight from the <a href="https://github.com/goome-ui/java-goome/releases">java-goome releases</a>, with the native lib for every OS inside.
</p>

```sh
./gradlew run           # gradlew.bat run on windows
./gradlew installDist   # a runnable copy in build/install/my-goome-app
```

<p align="center">
The goome version is <code>goome_version</code> in <code>gradle.properties</code>. Want Java 17 or 21? Then goome goes through LWJGL, add <code>org.lwjgl:lwjgl</code> 3.3+ and its natives to the dependencies and set <code>options.release</code> to 17.
</p>
</details>

<details>
<summary align="center"><b>🧩 Other Templates 🧩</b></summary>

<br>

<p align="center">
<code>variants/</code> has the other starting points. Each one is the file that replaces <code>src/main/java/mygoomeapp/Main.java</code>:<br> <br>
<b>overlay</b> - a see-through overlay over the whole desktop, only the window takes clicks. alt+h hides it<br>
<b>mod-menu</b> - a menu with toggles and sliders over whatever game is running, alt+m opens and closes it<br>
<b>hud</b> - a little panel in the corner with the time and fps, every click goes straight through it<br><br>
<code>goome new</code> puts the one you pick in place for you. By hand, copy the file over <code>src/main/java/mygoomeapp/Main.java</code> and delete <code>variants/</code>.
</p>
</details>

<details>
<summary align="center"><b>🧪 Testing Without A Screen 🧪</b></summary>

<br>

<p align="center">
goome has a test backend that fakes a whole screen, so the app runs in CI with nothing on screen. The script says what the "user" does and you get a screenshot of every frame in <code>shots/</code>. This one clicks the toggle:
</p>

```sh
GOOME_BACKEND=test GOOME_TEST_SHOTS=shots/ GOOME_TEST_SCRIPT="screen 1280x720 1; 3 click 60,28; end 6" ./gradlew -q run
```

<p align="center">
CI does that on linux, windows and mac on every push. The script format is in the <a href="https://github.com/goome-ui/c-goome/blob/main/docs/DESIGN.md">c-goome docs</a> under Test.
</p>
</details>

<details>
<summary align="center"><b>🛠 Pull Requests 🛠</b></summary>

<br>

<p align="center">
Want to help with this template? Make A pull request to <b>dev</b>!<br>
Keep it small, its supposed to be the least code you need to get going. Bugs in goome itself go to <a href="https://github.com/goome-ui/java-goome">java-goome</a>.<br> <br>
As long as it works, and doesnt vary off too far from the main idea its very likely it get accepted!<br>
Read <a href="CONTRIBUTING.md">CONTRIBUTING.md</a> before you send one.
</p>
</details>

<p align="center">
<b>🫶 Contributors 🫶</b><br>
Thanks to everyone who helped out!<br> <br>
<a href="https://github.com/goome-ui/goome-app-template-java/graphs/contributors"><img src="https://contrib.rocks/image?repo=goome-ui/goome-app-template-java" alt="contributors"></a>
</p>

<details>
<summary align="center"><b>⚖️ License ⚖️</b></summary>

<br>

<p align="center">
This template is under the <a href="LICENSE">GPL-3.0</a>, same as goome.<br> <br>
<sub>
• You can use it, change it and share it<br>
• If you share something made with it, you have to share your source too, under the same license<br>
• Keep the credits
</sub><br> <br>
In short: play fair, keep it open, and give credit where it's due.
</p>
</details>

<details>
<summary align="center"><b>🩷 Donate 🩷</b></summary>

<br>

<p align="center">
<a href="https://sevvy-wevvy.com/kofi">Ko-fi</a> (Preferred)<br>
<a href="https://sevvy-wevvy.com/patreon">Patreon</a><br>
<a href="https://sevvy-wevvy.com/throne">Throne</a>
</p>
</details>
