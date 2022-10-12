package InitModuleProject.model;

public class FileVO {
	
	private final static FileVO instance = new FileVO();

	private long fno;
	private long bno;
	private String fName;
	private String fPath;

    public static FileVO getInstance() {
        return instance;
    };
	
	
	public FileVO() {}




	public FileVO(long fno, long bno, String fName, String fPath) {
		super();
		this.fno = fno;
		this.bno = bno;
		this.fName = fName;
		this.fPath = fPath;
	}




	public long getFno() {
		return fno;
	}




	public void setFno(long fno) {
		this.fno = fno;
	}




	public long getBno() {
		return bno;
	}




	public void setBno(long bno) {
		this.bno = bno;
	}




	public String getfName() {
		return fName;
	}




	public void setfName(String fName) {
		this.fName = fName;
	}




	public String getfPath() {
		return fPath;
	}




	public void setfPath(String fPath) {
		this.fPath = fPath;
	}




	
	
	
}
