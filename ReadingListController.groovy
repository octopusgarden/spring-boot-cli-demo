@Controller
@RequestMapping("/")
class ReadingListController {

    String reader = "Craig"

    @Autowired
    ReadingListRepository readingListRepository

    @RequestMapping(method = RequestMethod.GET)
    def readersBooks(final Model model) {
        final List<Book> readingList = readingListRepository.findByReader(reader)

        if (readingList != null) {
            model.addAttribute("books", readingList)
        }

        "readingList"
    }

    @RequestMapping(method = RequestMethod.POST)
    def addToReadingList(final Book book) {
        book.setReader(reader)
        readingListRepository.save(book)
        "redirect:/"
    }

}