import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
/**
* 1.ѡ�񱻸��Ƶ�ԴĿ¼��sourcePath
* 2.ѡ���ļ������ƺ��ŵ�Ŀ��Ŀ¼��targetPath
* 3.�ļ���׺�������ļ������ҽ��ļ����Ƶ���ͬ���ļ���
*
*/
public class FileDemo {
/**
* ��������
* @param args
*/
public static void main(String[] args) {
/**
* ѡ�񱻸��Ƶ�ԴĿ¼��sourcePath
*/
File sourcePath = getSourcePath();
/**
* ѡ���ļ������ƺ��ŵ�Ŀ��Ŀ¼��targetPath
*/
File outputPath = getOutputPath();
/**
* ִ�и��Ʋ���
*/
handlePath(sourcePath, outputPath);
}
/**
* �����ļ����ิ��
* @param sourcePath
* @param outputPath
*/
private static void handlePath(File sourcePath, File outputPath) {
if (sourcePath == null || outputPath == null) //1.���û��ѡ��ԴĿ¼��Ŀ��Ŀ¼���򷵻�
return;
for (File file : sourcePath.listFiles()) { //2.ȡ��ԴĿ¼�����е��ļ����ļ��У������б���
if (file.isDirectory()) {
//3.�����ǰ���������ļ��У���ʹ�õݹ���ã�����������ļ�������������ļ����ļ���
handlePath(file, outputPath);
} else {
//4.�����ǰ�������ǲ����ļ��ж����ļ�����ôֱ�ӿ�ʼcopy�Ĳ���
//4.1.ȡ���ļ����ļ����������ļ���׺��
String fileName = file.getName();
if (fileName.contains(".")) {
//4.2.1.������ļ��к�׺������������.������ţ���ȡ���ļ��ĺ�׺��Ϊ�����һ������ź�����ַ���
String suffix = fileName.substring(fileName.lastIndexOf('.') + 1);
//4.2.2.�����ļ����������Ŀ��Ŀ¼���ļ��ĺ�׺����ִ��copy�Ĳ�������Ϊ��������ʽΪ���ļ��ĺ�׺�����࣬���������磺pdfĿ¼������pdf�ļ���txtĿ¼������txt�ļ���
copy(file, new File(outputPath, suffix));
} else {
//4.3.������ļ�û�к�׺��������������.������ţ���ֱ�����ļ����������Ŀ��Ŀ¼�½�����nosuffix��Ŀ¼��ִ��copy�Ĳ�������û�к�׺�����ļ����Ƶ�nosuffixĿ¼��
copy(file, new File(outputPath, "nosuffix"));
}
}
}
}
/**
* �����ļ����Ʋ���
* @param sourceFile
* @param targetDir
*/
private static void copy(File sourceFile , File targetDir){
System.out.println("copying " + sourceFile);
//1.���Ŀ��Ŀ¼�����ڣ����½����˴���Ŀ��Ŀ¼Ϊ���ļ���׺��������Ŀ¼����pdfĿ¼��txtĿ¼�Լ�nosuffixĿ¼
if(!targetDir.exists()){
targetDir.mkdir();//�½�Ŀ¼
}
try {
//2.��Դ�ļ���ȡ����������
FileInputStream fis = new FileInputStream(sourceFile);
//3.����Ŀ��Ŀ¼���ļ��������ļ������
FileOutputStream fos = new FileOutputStream(new File(targetDir , sourceFile.getName())) ;
//4.���建��������СΪ102400byte
byte[] buf = new byte[102400];
//5.������������ȡ�����ļ���С��������õ�
int available = 0;
//6.fis.available()��ʹ��������fis��ȡ��ǰ�ļ��Ĵ�С������ȡ���Ĵ�С��ֵ��available
while((available = fis.available()) > buf.length){
//7.�����ǰ��ȡ���Ĵ�Сavailable���ڶ���Ļ������Ĵ�С102400������fis.read(buf)������ȡ�ļ���
//��ʱ��������buf�ᱻ��ȫ��������Դ�ļ���ǰ102400 byte�����ݶ��ᱻ��ȡ��buf�У�
//fis��һ�ζ�ȡ�ͻ��102401 byte��ʼ�������ļ���ȡ�Ŀ�ʼλ���ƶ�����available+1��λ����
fis.read(buf);
//8.ʹ���ļ�������fos��������buf�е�����д�뵽Ŀ���ļ���
fos.write(buf);
}
//9.�����ѭ��ʼ�ջ��������Ϊ�ļ��Ĵ�С���������޵Ĵ󣬵�����ѭ�����ж�ʹ��fis.available()��ȡ����ǰʣ����ļ���СС��102400 byteʱ��
//ʹ��fis.read(buf, 0, available)��ʣ����ļ����ݶ�ȡ��buf��Ӧ��λ�ã�
//���磬���ʣ�µ��ļ����ݴ�СΪ100 byte����available��ֵΪ100����ôʹ��ִ�з���fis.read(buf, 0, available)����
//buf�����е�buf[0]��buf[99]�������ݣ�buf[100]֮��ľͶ��ǿ��ˡ�
fis.read(buf, 0, available);
//10.���������fos.write(buf, 0, available)��ʾ��buf�е�ǰavailable��С�����������
//��������ٵ����ӣ���ֻ�Ὣbuf�е�ǰ100λ���������
fos.write(buf, 0, available);
fis.close();
fos.close();
} catch (Exception e) {
e.printStackTrace();
}
}
/**
* �����ļ�ѡ��Ի���ѡ��Ҫ�����Ƶ�ԴĿ¼
* @return
*/
private static File getSourcePath(){
//1.�����ļ�ѡ��Ի���
JFileChooser chooser = new JFileChooser();
//2.����ֻ��ѡ��Ŀ¼
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//3.����ѡ���Ŀ¼�����û��ѡ���򷵻�null
if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
return chooser.getSelectedFile();
}
return null;
}
/**
* �����Ի���ѡ���ļ����ƺ��ŵ�Ŀ��Ŀ¼
* @return
*/
private static File getOutputPath(){
//1.�����ļ�ѡ��Ի���
JFileChooser chooser = new JFileChooser();
//2.����ֻ��ѡ��Ŀ¼
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//3.����ѡ���Ŀ¼�����û��ѡ���򷵻�null
if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
return chooser.getSelectedFile();
}
return null;
}
}