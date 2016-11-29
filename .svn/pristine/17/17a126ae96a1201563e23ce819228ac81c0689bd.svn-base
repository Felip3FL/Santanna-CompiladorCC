package api.fileio.exemplos;

import java.io.File;
import java.io.IOException;

public class TesteX  {
	public static void main(String[] args) throws IOException {
		ProcessBuilder proc = new ProcessBuilder("/bin/bash", "-c", "pwd;ls -l");
		proc.directory(new File("/Library"));
		proc.redirectOutput(new File("/Area/Media/pena/Desktop/proc.txt"));
		proc.start();
	}
}
