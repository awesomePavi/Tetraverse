.SUFFIXES: .java .class

.java.class:
	javac -g $*.java
SOURCES = \
	Block_Blank.java \
	Block_Bomb.java \
	Block_I.java \
	Block_J.java \
	Block_L.java \
	Block_MiniL.java \
	Block_O.java \
	Block_One.java \
	Block_S.java \
	Block_T.java \
	Block_Three.java \
	Block_Two.java \
	Block_Z.java \
	Board.java \
	CustomModeScreen.java \
	Exit.java \
	gameOverAgain.java \
	Game.java \
	gameColour.java \
	GameKeyboard.java \
	gameover_Exit.java \
	gameover_Menu.java \
	GameOver.java \
	InBtwn1_Instructions.java \
	GamePanel.java \
	GameType.java \
	HighScoreScreen.java \
	InBetweenMenu.java \
	InBtwn_Buttons.java \
	InBtwn1_HighScore.java \
	Main.java \
	InBtwn1_Menu.java \
	InBtwn1_Play.java \
	InBtwn2_Instructions.java \
	InBtwn2_Menu.java \
	InBtwn2_Play.java \
	InBtwn1_Menu.java \
	KeyLayout.java \
	Pause_Menu.java \
	MainMenu.java \
	MMenu_AR.java \
	MMenu_Cl.java \
	MMenu_Cu.java \
	Pause_Exit.java \
	Shape.java \
	Pause_Restart.java \
	Pause_Resume.java \
	PauseMenu.java \
	ScreenRotation.java \
	Tester.java

CLASSES = \
	Block_Blank.class \
	Block_Bomb.class \
	Block_I.class \
	Block_J.class \
	Block_L.class \
	Block_MiniL.class \
	Block_O.class \
	Block_One.class \
	Block_S.class \
	Block_T.class \
	Block_Three.class \
	Block_Two.class \
	Block_Z.class \
	Board.class \
	CustomModeScreen.class \
	Exit.class \
	gameOverAgain.class \
	Game.class \
	gameColour.class \
	GameKeyboard.class \
	gameover_Exit.class \
	gameover_Menu.class \
	GameOver.class \
	InBtwn1_Instructions.class \
	GamePanel.class \
	GameType.class \
	HighScoreScreen.class \
	InBetweenMenu.class \
	InBtwn_Buttons.class \
	InBtwn1_HighScore.class \
	Main.class \
	InBtwn1_Menu.class \
	InBtwn1_Play.class \
	InBtwn2_Instructions.class \
	InBtwn2_Menu.class \
	InBtwn2_Play.class \
	InBtwn1_Menu.class \
	KeyLayout.class \
	Pause_Menu.class \
	MainMenu.class \
	MMenu_AR.class \
	MMenu_Cl.class \
	MMenu_Cu.class \
	Pause_Exit.class \
	Shape.class \
	Pause_Restart.class \
	Pause_Resume.class \
	PauseMenu.class \
	ScreenRotation.class \
	Tester.class

default:  classes

classes: $(SOURCES:.java=.class); jar cvfe Tetraverse.jar Main *.class; $(RM) *.class *~



clean:
	$(RM) *.class *~
	$(RM) *.jar *~