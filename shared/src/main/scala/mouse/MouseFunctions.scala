package mouse

trait MouseFunctions {

  /**
   * Evaluate but ignore the provided argument. This function makes value discarding an explicit operation, helpful when
   * the `-Ywarn-discard-values` compiler flag is enable to explicitly satisfy warnings.
   *
   * @param a
   *   - the value to be evaluated and ignored.
   */
  def ignore(a: Any): Unit = ()

}
