object ApkVersionHandler {
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val buildNumber = 1

    fun generateVersionCode() : Int {
        return "$versionMajor$versionMinor$versionPatch".toInt()
    }
    fun generateVersionName() : String{
        return "${versionMajor}.${versionMinor}.${versionPatch}-build$buildNumber"
    }
}