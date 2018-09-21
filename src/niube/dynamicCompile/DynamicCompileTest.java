package niube.dynamicCompile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class DynamicCompileTest {

	public static void main(String[] args) {
		compile();
	}

	public static void compile() {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

		File file = new File("C:\\Users\\cilu\\niube\\niube\\src\\daily\\d20180827\\BTraceTest.java");
		Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(file);
		DiagnosticCollector<JavaFileObject> diagnosticCollector = new DiagnosticCollector<JavaFileObject>();
		List<String> options = Arrays.asList("-d", "C:\\");
		CompilationTask task = compiler.getTask(null, fileManager, diagnosticCollector, options, null, compilationUnits);
		task.call();
	}
}
