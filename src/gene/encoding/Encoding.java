package gene.encoding;

public interface Encoding {
  String getData();

  void mutate(double mutationRate);
}
