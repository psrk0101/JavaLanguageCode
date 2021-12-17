package pattern.builder;

public class BuilderObject {
	private String member1;
	private String member2;
	private String member3;
	private String member4;

	public BuilderObject setMember1(String member1) {
		this.member1 = member1;
		return this;
	}

	public BuilderObject setMember2(String member2) {
		this.member2 = member2;
		return this;
	}

	public BuilderObject setMember3(String member3) {
		this.member3 = member3;
		return this;
	}

	public BuilderObject setMember4(String member4) {
		this.member4 = member4;
		return this;
	}
}
